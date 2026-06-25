package com.example.gameapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gameapplication.data.local.AppPreferences
import com.example.gameapplication.presentation.login.LoginScreen
import com.example.gameapplication.presentation.login.LoginViewModel
import com.example.gameapplication.presentation.register.RegisterScreen
import com.example.gameapplication.presentation.register.RegisterViewModel
import com.example.gameapplication.presentation.splash.Pager
import com.example.gameapplication.presentation.splash.SplashScreen
import com.example.network.storage.TokenStorage

@Composable
fun AppNavigation(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    registerViewModel: RegisterViewModel,
    tokenStorage: TokenStorage
) {

    val context = LocalContext.current
    val appPreferences = remember { AppPreferences(context) }

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(
                appPreferences = appPreferences,
                onNavigateToOnboarding = {
                    navController.navigate("onboarding") {
                        popUpTo("splash") { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        composable("onboarding") {
            Pager(
                appPreferences = appPreferences,
                onFinish = {
                    navController.navigate("register") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                }
            )
        }

        composable("login") {
            LoginScreen(
                viewModel = loginViewModel,
                onSuccess = {
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onGoRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                viewModel = registerViewModel,
                onSuccess = {
                    navController.navigate("main") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                onGoLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("main") {
            MainNavGraph(tokenStorage = tokenStorage)
        }
    }
}