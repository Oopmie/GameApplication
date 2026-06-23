package com.example.gameapplication.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.R
import com.example.uikit.AppButton
import com.example.uikit.AppPasswordField
import com.example.uikit.AppTextField
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onSuccess: () -> Unit,
    onGoRegister: () -> Unit
) {
    val state by viewModel.state

    Column(
        modifier = Modifier
            .verticalScroll(enabled = true, state = ScrollState(0))
            .background(color = White)
            .padding(vertical = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.login),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text("Welcome Back!", color = TextPink, style = AppTypography.displayLarge)

            Text(
                "Hi, Kindly login to continue battle",
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight(400))
            )
        }

        Column(modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 40.dp)) {
            AppTextField(
                value = state.email,
                onValueChange = viewModel::onEmailChange,
                placeholder = "Email"
            )

            AppPasswordField(
                value = state.password,
                onValueChange = viewModel::onPasswordChange
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            state.error?.let {
                Text(it, color = Color.Red)
            }

            AppButton(
                "Let's Combat",
                onClick = { viewModel.login(onSuccess) },
                modifier = Modifier.width(200.dp)
            )

            Text("Connect With:", color = TextPink)
            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier.width(40.dp),
                    contentScale = ContentScale.FillWidth
                )
                Image(
                    painter = painterResource(R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier.width(40.dp),
                    contentScale = ContentScale.FillWidth
                )
            }

            Text("Don't have an account?")

            TextButton(onClick = onGoRegister) {
                Text("Create Account", color = TextPink)
            }
        }
    }
}