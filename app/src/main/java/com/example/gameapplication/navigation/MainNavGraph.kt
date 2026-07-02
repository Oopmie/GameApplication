package com.example.gameapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gameapplication.R
import com.example.gameapplication.presentation.discover.CombatInformationScreen
import com.example.gameapplication.presentation.discover.DiscoverScreen
import com.example.gameapplication.presentation.games.CircleGameScreen
import com.example.gameapplication.presentation.games.ImageGameScreen
import com.example.gameapplication.presentation.home.HomeScreen
import com.example.gameapplication.presentation.discover.ProfileScreen
import com.example.gameapplication.presentation.schedule.ScheduleGameScreen
import com.example.uikit.SuccessScreen
import com.example.gameapplication.presentation.statistics.StatisticsScreen
import com.example.gameapplication.presentation.statistics.StatisticsViewModel
import com.example.network.api.ApiService
import com.example.network.storage.TokenStorage

@Composable
fun MainNavGraph(
    tokenStorage: TokenStorage,
    api: ApiService
) {
    val navController = rememberNavController()

    val username = tokenStorage.getUsername().orEmpty()
    val userId = tokenStorage.getUserId().orEmpty()

    val bottomItems = listOf(
        BottomNavItemData(
            "Statistics",
            "Statistics",
            icon = com.example.gameapplication.R.drawable.statistics_icon
        ),
        BottomNavItemData(
            "Discover",
            "Discover",
            icon = com.example.gameapplication.R.drawable.loc_pin
        ),
        BottomNavItemData(
            "Schedule",
            "Schedule",
            icon = com.example.gameapplication.R.drawable.schedule
        ),
        BottomNavItemData(
            "Chat",
            "Chat",
            icon = com.example.gameapplication.R.drawable.chat
        ),
        BottomNavItemData(
            "Profile",
            "Profile",
            icon = com.example.gameapplication.R.drawable.profile
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute == "home" ||
                currentRoute in bottomItems.map { it.route }
            ) {
                AppBottomBar(
                    items = bottomItems,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navController.navigate(item.route) {
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
                    onNavigate = {
                        navController.navigate(it)
                    },
                    onLogout = {
                        tokenStorage.clearUser()

                        navController.navigate("login") {
                            popUpTo("home") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable("statistics") {
                StatisticsScreen(
                    viewModel = remember {
                        StatisticsViewModel(
                            api = api,
                            tokenStorage = tokenStorage
                        )
                    },
                    onBack = { navController.navigate("home") }
                )
            }

            composable("schedule") {
                ScheduleGameScreen(
                    onBackClick = { navController.popBackStack() },
                    onPublishClick = { gameName, category, price, description, notify ->
                        navController.navigate("successPublish")
                    }
                )
            }

            composable("circle_game") {
                CircleGameScreen(
                    userId = userId,
                    api = api,
                    onFinish = {
                        navController.navigate("successGame")
                    }
                )
            }

            composable("image_game") {
                ImageGameScreen(
                    onFinish = {
                        navController.navigate("successGame")
                    }
                )
            }

            composable("discover") {
                DiscoverScreen(
                    onBack = { navController.popBackStack() },
                    onInfoClick = {
                        navController.navigate("combatInfo")
                    }
                )
            }

            composable("combatInfo") {
                CombatInformationScreen(
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable("successGame") {
                SuccessScreen(
                    successIc = R.drawable.success_icon,
                    close = R.drawable.close,
                    mainText = "You Winner",
                    text = "",
                    buttonText = "Discover combats",
                    onContinue = {
                        navController.navigate("profile") {
                            popUpTo("profile") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable("successPublish") {
                SuccessScreen(
                    successIc = R.drawable.success_icon,
                    close = R.drawable.close,
                    mainText = "Published Successful",
                    text = "Wanna change/edit your scheduled game before it begins?",
                    buttonText = "Statistics",
                    onContinue = {
                        navController.navigate("statistics") {
                            popUpTo("statistics") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable("successDiscover") {
                SuccessScreen(
                    successIc = R.drawable.success_icon,
                    close = R.drawable.close,
                    mainText = "Successfully \n" +
                            "Join Combat",
                    text = "Wanna know more information bout’ this competition?",
                    buttonText = "Discover combats",
                    onContinue = {
                        navController.navigate("discover") {
                            popUpTo("discover") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable("chat") {
                Text("Chat Screen")
            }

            composable("profile") {
                ProfileScreen(
                    onBack = { navController.popBackStack() },
                    goImage = { navController.navigate("image_game") },
                    goCircle = { navController.navigate("circle_game") },
                    onInfoClick = { navController.navigate("combatInfo")},
                    username = username
                )
            }
        }
    }
}