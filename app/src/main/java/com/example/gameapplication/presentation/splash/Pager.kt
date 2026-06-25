package com.example.gameapplication.presentation.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.gameapplication.data.local.AppPreferences

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(
    appPreferences: AppPreferences,
    onFinish: () -> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )

    HorizontalPager(
        state = pagerState
    ) { page ->

        when (page) {
            0 -> Onboarding1(
                onSkip = {
                    appPreferences.setFirstLaunchDone()
                    onFinish()
                }
            )

            1 -> Onboarding2(
                onSkip = {
                    appPreferences.setFirstLaunchDone()
                    onFinish()
                }
            )

            2 -> Onboarding3(
                onFinish = {
                    appPreferences.setFirstLaunchDone()
                    onFinish()
                }
            )
        }
    }
}