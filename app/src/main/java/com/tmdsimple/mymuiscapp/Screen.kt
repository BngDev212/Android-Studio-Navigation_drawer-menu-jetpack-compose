package com.tmdsimple.mymuiscapp

import androidx.annotation.DrawableRes

sealed class Screen (val title : String, val route : String
){
   sealed class DrawerScreen( val drawerTitle : String, val drawerRoute : String, @DrawableRes val icon : Int):
                  Screen(drawerTitle,drawerRoute)
   {
         object MyAccount: DrawerScreen(
             "My Account",
             "my_account",
             R.drawable.ic_account_24
         )

       object AddAccount: DrawerScreen(
           "Add Account",
           "add_account",
           R.drawable.ic_add_account_24
       )

       object AddMusic: DrawerScreen(
           "Add Music",
           "add_music",
           R.drawable.id_add_music_video_24
       )


   }
}

val itemsInDrawer = listOf(
    Screen.DrawerScreen.MyAccount,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.AddMusic
    )