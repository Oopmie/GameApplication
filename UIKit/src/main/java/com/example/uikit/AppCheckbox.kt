package com.example.uikit

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable

@Composable
fun AppCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}