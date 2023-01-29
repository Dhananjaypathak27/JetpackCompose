package com.inxparticle.jetpackcompose

sealed class NavigationDrawerActivityRoutes(val routes:String) {
    object Home: NavigationDrawerActivityRoutes("home")
    object Profile: NavigationDrawerActivityRoutes("profile")
    object Search: NavigationDrawerActivityRoutes("Search")
    object Settings: NavigationDrawerActivityRoutes("settings")
    object Notification: NavigationDrawerActivityRoutes("Notification")
    object Like: NavigationDrawerActivityRoutes("Like")
    object Message: NavigationDrawerActivityRoutes("Message")
}