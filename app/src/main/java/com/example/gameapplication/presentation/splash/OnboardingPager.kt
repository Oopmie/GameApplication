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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gameapplication.R
import com.example.gameapplication.data.local.AppPreferences
import com.example.uikit.AppButton
import com.example.uikit.AppPagination
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun OnboardingScreen(
    appPreferences: AppPreferences,
    onSkip: () -> Unit,
    onFinish: () -> Unit
) {
    val pages = listOf(
        OnboardingPage(
            image = R.drawable.onboarding,
            title = "Get Paid! Playing Video Game",
            description = "Earn points and real cash when you win a battle with no delay in cashing out"
        ),
        OnboardingPage(
            image = R.drawable.onboardingg,
            title = "Schedule Games With Friends",
            description = "Easily create an upcoming event and get ready for battle."
        ),
        OnboardingPage(
            image = R.drawable.onboardinggg,
            title = "Text, Audio and Video Chat",
            description = "Chat with fellow gamers before and after combat for free!"
        )
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pages.size }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->

            val item = pages[page]

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 130.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(item.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    modifier = Modifier.padding(horizontal = 80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    Text(
                        text = item.title,
                        color = TextPink,
                        style = AppTypography.displayLarge,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = item.description,
                        textAlign = TextAlign.Center
                    )

                    TextButton(
                        onClick = {
                            appPreferences.setFirstLaunchDone()
                            onSkip()
                        }
                    ) {
                        Text("Skip")
                    }

                    AppPagination(
                        current = pagerState.currentPage,
                        total = pages.size
                    )

                    if (page == pages.lastIndex) {
                        AppButton(
                            "Let’s Combat!",
                            {
                                appPreferences.setFirstLaunchDone()
                                onFinish()
                            })
                    }
                }
            }
        }
    }
}