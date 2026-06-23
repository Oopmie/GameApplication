package com.example.gameapplication.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.R
import com.example.gameapplication.data.local.AppPreferences
import com.example.uikit.AppButton
import com.example.uikit.AppPagination
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun Onboarding1(
    onSkip: () -> Unit
) {

    Column(
        modifier = Modifier
            .background(color = White)
            .padding(top = 130.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.onboarding),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 80.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "Get Paid! Playing Video Game",
                color = TextPink,
                style = AppTypography.displayLarge,
                textAlign = TextAlign.Center
            )

            Text(
                "Earn points and real cash when you win a battle with no delay in cashing out",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center
                )
            )

            TextButton(onClick = onSkip) {
                Text(
                    "Skip", textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight(700),
                    color = TextPink
                )
            }

            AppPagination(current = 0, total = 3)
        }
    }
}