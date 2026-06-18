package com.example.uikit

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun AppTopBar(
    title: String,
    onBack: () -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton (onClick = onBack) {
            Icon(
                Icons.Default.ArrowBackIosNew,
                contentDescription = null
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}