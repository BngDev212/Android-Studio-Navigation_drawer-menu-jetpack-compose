package com.tmdsimple.mymuiscapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyAccountView(){
    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        Row (modifier = Modifier.fillMaxWidth(),
             horizontalArrangement = Arrangement.SpaceBetween){

             Text("My Account Details")

        }
        Row (modifier = Modifier.padding(top = 16.dp)){

            Text("Tutorial Made Simple")

        }
        Divider()

    }
}