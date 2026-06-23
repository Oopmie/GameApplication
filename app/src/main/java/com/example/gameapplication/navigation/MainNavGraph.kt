package com.example.gameapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gameapplication.presentation.main.DiscoverScreen
import com.example.gameapplication.presentation.main.HomeScreen
import com.example.gameapplication.presentation.main.ProfileScreen
import com.example.gameapplication.presentation.main.ScheduleScreen
import com.example.gameapplication.presentation.main.StatisticsScreen

@Composable
fun MainNavGraph() {

    val navController = rememberNavController()

    val bottomItems = listOf(
        BottomNavItemData(
            route = "statistics",
            title = "Statistics"
        ),
        BottomNavItemData(
            route = "discover",
            title = "Discover"
        ),
        BottomNavItemData(
            route = "schedule",
            title = "Schedule"
        ),
        BottomNavItemData(
            route = "chat",
            title = "Chat"
        ),
        BottomNavItemData(
            route = "profile",
            title = "Profile"
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute == "home" ||
                bottomItems.any { it.route == currentRoute }) {
                AppBottomBar(
                    items = bottomItems,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navController.navigate(item.route){
                            popUpTo("home")
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {

            composable("home") {
                HomeScreen()
            }

            composable("statistics") {
                StatisticsScreen()
            }

            composable("discover") {
                DiscoverScreen()
            }

            composable("schedule") {
                ScheduleScreen()
            }

            composable("chat") {

            }

            composable("profile") {
                ProfileScreen()
            }
        }
    }
}