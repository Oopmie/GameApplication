package com.example.gameapplication.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.R
import com.example.uikit.AppButton
import com.example.uikit.AppPagination
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun Onboarding3(
    onFinish: () -> Unit
) {

    Column(
        modifier = Modifier
            .background(color = White)
            .padding(top = 130.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.onboardinggg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .padding(start = 80.dp, end = 80.dp, bottom = 60.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Text, Audio and Video Chat",
                color = TextPink,
                style = AppTypography.displayLarge,
                textAlign = TextAlign.Center
            )

            Text(
                "Intuitive real life experience on mobile. Chat with fellow gamers before and after combat for free!",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center
                )
            )

            AppButton(
                "Let’s Combat!",
                {
                    onFinish()
                })

            AppPagination(current = 2, total = 3)
        }
    }
}