package com.tmdsimple.mymuiscapp.ui.theme

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tmdsimple.mymuiscapp.MainViewModel
import com.tmdsimple.mymuiscapp.Navigation
import com.tmdsimple.mymuiscapp.Screen
import com.tmdsimple.mymuiscapp.itemsInDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    val controller : NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val viewModel : MainViewModel = viewModel()
    val currentScreen =
        remember {
            viewModel.currentScreen.value
        }


    val title = remember {
               mutableStateOf(currentScreen.title)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                modifier = Modifier.background(MaterialTheme.colors.primary),
                title = { Text(title.value) },
                navigationIcon = { IconButton(onClick = {
                    // Open the drawer ..
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                 //Icon(painter = painterResource(id = R.drawable.id_add_music_video_24) , contentDescription ="Menu" )
                  Icon(imageVector = Icons.Default.Menu , contentDescription = "Menu" )
                } }
                )
        },
        drawerContent = {
                DrawHeader()
                LazyColumn(Modifier.padding(32.dp)){
                items(itemsInDrawer) {
                    item -> DrawerItem(selected = currentRoute == item.drawerRoute, item=item){
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    //if (item.drawerRoute == "add_account") {
                        // to do - add account dialog
                    //}else{
                        controller.navigate(item.drawerRoute)
                        title.value = item.drawerTitle
                    //}
                }
                }
            }
        }

    ) {
        Navigation(navController= controller, viewModel = viewModel, pad=it)
    }

}

@Composable
fun DrawHeader()
{
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ){
        Text("Menu", fontSize = 30.sp)
    }
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked : () -> Unit

) {

    val background = if (selected) Color.Cyan else Color.White

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }){
        Icon(
            painter = painterResource(id= item.icon),
            contentDescription = item.drawerTitle,
            Modifier.padding(end= 8.dp, top=4.dp)
        )
        Text(
            text = item.drawerTitle,
            style = MaterialTheme.typography.h5
        )
    }
}


