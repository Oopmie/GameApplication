package com.example.uikit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.AppRoundedMedium

@Composable
fun AppCard(
    content: @Composable ColumnScope.() -> Unit
) {
    Card (
        modifier = Modifier.fillMaxWidth(),
        shape = AppRoundedMedium
    ) {
        Column (
            modifier = Modifier.padding(16.dp),
            content = content
        )
    }
}