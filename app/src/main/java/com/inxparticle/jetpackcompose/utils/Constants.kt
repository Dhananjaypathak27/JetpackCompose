package com.inxparticle.jetpackcompose.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.inxparticle.jetpackcompose.models.BottomNavItem


object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            label = "Like",
            icon = Icons.Filled.Favorite,
            route = "Like"
        ),
        BottomNavItem(
            label = "Message",
            icon = Icons.Filled.MailOutline,
            route = "Message"
        )
    ,BottomNavItem(
            label = "Notification",
            icon = Icons.Filled.Notifications,
            route = "Notification"
        )
    )
}