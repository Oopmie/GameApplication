package com.example.gameapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gameapplication.presentation.discover.DiscoverScreen
import com.example.gameapplication.presentation.home.HomeScreen
import com.example.gameapplication.presentation.profile.ProfileScreen
import com.example.gameapplication.presentation.schedule.ScheduleScreen
import com.example.gameapplication.presentation.schedule.ScheduleViewModel
import com.example.gameapplication.presentation.statistics.StatisticsScreen
import com.example.network.di.NetworkModule
import com.example.network.storage.TokenStorage

@Composable
fun MainNavGraph(
    tokenStorage: TokenStorage
) {
    val navController = rememberNavController()

    val username = tokenStorage.getUsername().orEmpty()

    val bottomItems = listOf(
        BottomNavItemData("home", "Home"),
        BottomNavItemData("statistics", "Statistics"),
        BottomNavItemData("discover", "Discover"),
        BottomNavItemData("schedule", "Schedule"),
        BottomNavItemData("chat", "Chat"),
        BottomNavItemData("profile", "Profile")
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomItems.map { it.route }) {
                AppBottomBar(
                    items = bottomItems,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navController.navigate(item.route) {
                            popUpTo("home")
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {

            composable("home") {
                HomeScreen(
                    username = username,
                    onNavigate = { route ->
                        navController.navigate(route)
                    },
                    onLogout = {
                        tokenStorage.clearToken()

                        navController.navigate("login") {
                            popUpTo("home") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable("statistics") {
                StatisticsScreen()
            }

            composable("discover") {
                DiscoverScreen()
            }

            composable("schedule") {

                val api = remember {
                    NetworkModule.create(tokenStorage)
                }

                val viewModel = remember {
                    ScheduleViewModel(
                        api = api,
                        tokenStorage = tokenStorage
                    )
                }

                ScheduleScreen(
                    viewModel = viewModel,
                    onSuccess = {
                        navController.navigate("success")
                    }
                )
            }

            composable("chat") {

            }

            composable("profile") {
                ProfileScreen()
            }
        }
    }
}

fun currentRoute(navController: NavHostController): String? {
    return navController.currentBackStackEntry?.destination?.route
}