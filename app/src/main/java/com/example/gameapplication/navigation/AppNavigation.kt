package com.example.gameapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gameapplication.presentation.login.LoginScreen
import com.example.gameapplication.presentation.login.LoginViewModel
import com.example.gameapplication.presentation.register.RegisterScreen
import com.example.gameapplication.presentation.register.RegisterViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    registerViewModel: RegisterViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(
                viewModel = loginViewModel,
                onSuccess = {
                    navController.navigate("main") {
                        popUpTo("login") {
                            inclusive = true
                        }
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
                        popUpTo("register") {
                            inclusive = true
                        }
                    }
                },
                onGoLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("main") {
            MainNavGraph()
        }
    }
}