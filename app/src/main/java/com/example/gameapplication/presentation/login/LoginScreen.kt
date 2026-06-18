package com.example.gameapplication.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onSuccess: () -> Unit,
    onGoRegister: () -> Unit
) {
    val state = viewModel.state.value

    if (state.success) onSuccess()

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = state.email,
            onValueChange = viewModel::onEmailChange,
            placeholder = { Text("Email") }
        )

        TextField(
            value = state.password,
            onValueChange = viewModel::onPasswordChange,
            placeholder = { Text("Password") }
        )

        Button (onClick = { viewModel.login() }) {
            Text("Login")
        }

        TextButton (onClick = onGoRegister) {
            Text("Go Register")
        }

        state.error?.let {
            Text(it, color = Color.Red)
        }
    }
}