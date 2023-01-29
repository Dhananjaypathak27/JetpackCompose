package com.inxparticle.jetpackcompose

//https://www.geeksforgeeks.org/jetpack-compose-navigation-and-passing-data-in-android/
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.inxparticle.jetpackcompose.ui.components.*
import com.inxparticle.jetpackcompose.utils.Constants
import kotlinx.coroutines.launch

class NavigationDrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldBox()
        }
    }
}

@Preview
@Composable
fun ScaffoldBox() {
    val navController= rememberNavController()
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBarSection(
             onMenuClicked = {
                    coroutineScope.launch {
                        // to close use -> scaffoldState.drawerState.close()
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        bottomBar = {
//            BottomBarSection()
                    BottomNavigationBar(navController = navController)
        },
        drawerContent = {
            DrawerContext()
        },
                content = {
            ScreenMain(navController)
        },

    )
}

@Composable
fun TopBarSection(onMenuClicked: () -> Unit) {
    TopAppBar(
        backgroundColor = Color.LightGray,
        title = {
            Text(text = "This is app Bar")
        },
                navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                // When clicked trigger onClick
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = onMenuClicked),
                tint = Color.Blue
            )
        }
    )
}

@Composable
fun BottomBarSection() {
    BottomAppBar(
        backgroundColor = Color.LightGray,
    ) {
        Text(text = "this is bottom Bar Section")
    }

}

@Composable
fun DrawerContext() {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "hello this is section 1")
        Button(onClick = {

        }) {
            Text(text = "this is button")
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    var counter by remember{
        mutableStateOf(1)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "counter is $counter")
        Button(onClick = {
            counter++
        }) {
            Text(text = "Increment Counter")
        }
        Button(onClick = {
            navController.navigate(NavigationDrawerActivityRoutes.Profile.routes)
        }) {
            Text(text = "Move to Profile screen")
        }
    }
}

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {

        Column {
            Text(
                text = "Navigation without arguments",
                Modifier.padding(10.dp),
                color = Color.Black
            )
            Text(text = "Profile Screen", Modifier.padding(10.dp), color = Color.Black)
        }
    }
}

@Composable
fun ScreenMain( navController :NavHostController) {

    NavHost(navController = navController, startDestination = NavigationDrawerActivityRoutes.Home.routes){
        composable(NavigationDrawerActivityRoutes.Home.routes){
            Home(navController)
        }
        composable(NavigationDrawerActivityRoutes.Profile.routes){
            Profile()
        }
        composable(NavigationDrawerActivityRoutes.Search.routes){
            SearchScreen()
        }
        composable(NavigationDrawerActivityRoutes.Settings.routes){
            SettingScreen()
        }
        composable(NavigationDrawerActivityRoutes.Notification.routes){
            NotificationScreen()
        }
        composable(NavigationDrawerActivityRoutes.Like.routes){
            LikeScreen()
        }
        composable(NavigationDrawerActivityRoutes.Message.routes){
            MessageScreen()
        }

    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(

        // set background color
        backgroundColor = Color.LightGray) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon 
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
    }
}

