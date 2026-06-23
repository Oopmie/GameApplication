package com.example.uikit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uikit.theme.Black
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(placeholder)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = White,
            unfocusedTextColor = Black,
            focusedContainerColor = White,
            focusedTextColor = Black,
            focusedIndicatorColor = TextPink,
            unfocusedIndicatorColor = TextPink
        )
    )
}