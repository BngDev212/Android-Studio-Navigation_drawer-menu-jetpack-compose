package com.tmdsimple.mymuiscapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tmdsimple.mymuiscapp.ui.theme.MyAccountView

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pad: PaddingValues){

    NavHost(navController = navController as NavHostController,
            startDestination = Screen.DrawerScreen.AddAccount.route,
            modifier = Modifier.padding(pad))
            {
             composable(Screen.DrawerScreen.AddAccount.route){
                }

             composable(Screen.DrawerScreen.AddMusic.route){
               }

             composable(Screen.DrawerScreen.MyAccount.route){
                 MyAccountView()
               }


    }

}