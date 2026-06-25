package com.example.gameapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.gameapplication.data.repository.AuthRepositoryImpl
import com.example.gameapplication.domain.usecase.LoginUseCase
import com.example.gameapplication.domain.usecase.RegisterUseCase
import com.example.gameapplication.navigation.AppNavigation
import com.example.gameapplication.presentation.login.LoginViewModel
import com.example.gameapplication.presentation.register.RegisterViewModel
import com.example.network.di.NetworkModule
import com.example.network.storage.TokenStorage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            val tokenStorage = TokenStorage()
            val api = NetworkModule.create(tokenStorage)

            val authRepository = AuthRepositoryImpl(
                api = api,
                tokenStorage = tokenStorage
            )

            val loginUseCase = LoginUseCase(authRepository)
            val registerUseCase = RegisterUseCase(authRepository)

            val loginViewModel = LoginViewModel(loginUseCase)
            val registerViewModel = RegisterViewModel(registerUseCase)

            AppNavigation(
                navController = navController,
                loginViewModel = loginViewModel,
                registerViewModel = registerViewModel,
                tokenStorage = tokenStorage
            )
        }
    }
}