package com.example.storybook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.AppButton
import com.example.uikit.AppCard
import com.example.uikit.AppCheckbox
import com.example.uikit.AppDialog
import com.example.uikit.AppPagination
import com.example.uikit.AppPasswordField
import com.example.uikit.AppTextField
import com.example.uikit.AppTimerCard
import com.example.uikit.AppTopBar
import com.example.uikit.components.*
import com.example.uikit.theme.White

@Composable
fun StorybookScreen() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var selectedGame by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize().background(color = White)
            .verticalScroll(
                rememberScrollState()
            )
            .padding(horizontal = 16.dp, vertical = 100.dp)
        ,verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        AppTopBar(
            title = "StoryBook",
            onBack = {}
        )

        AppButton(
            text = "Primary Button",
            onClick = {}
        )

        AppTextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = "Email"
        )

        AppPasswordField(
            value = password,
            onValueChange = {
                password = it
            }
        )

        AppSelect(
            selected = selectedGame,
            items = listOf(
                "Image Puzzle",
                "Circle Sort"
            ),
            onSelect = {
                selectedGame = it
            }
        )

        AppCheckbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        AppTimerCard(
            time = "00:25:11"
        )

        AppCard {
            AppButton(
                text = "Card Button",
                onClick = {}
            )
        }

        AppPagination(
            current = 0,
            total = 3
        )

        var showDialog by remember { mutableStateOf(true) }
        if (showDialog) {
            AppDialog(
                title = "You Winner!",
                buttonText = "Continue",
                onClick = { showDialog = false }
            )
        }
    }
}