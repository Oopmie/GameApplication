package com.example.uikit

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AppDialog(
    title: String,
    buttonText: String,
    onClick: () -> Unit
) {
    Dialog (onDismissRequest = {}) {
        Card {
            Text (title)

            Spacer(modifier = Modifier.height(16.dp))

            AppButton(
                text = buttonText,
                onClick = onClick
            )
        }
    }
}