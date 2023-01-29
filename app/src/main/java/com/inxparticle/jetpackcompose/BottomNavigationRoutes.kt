package com.inxparticle.jetpackcompose

sealed class BottomNavigationRoutes(val routes:String) {
    object Home : BottomNavigationRoutes("Home")
    object Search : BottomNavigationRoutes("Search")
    object Profile : BottomNavigationRoutes("Profile")
}