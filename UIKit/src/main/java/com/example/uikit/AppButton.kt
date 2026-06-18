package com.example.uikit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.AppRoundedLarge
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.White

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = AppRoundedLarge,
        colors = ButtonDefaults.buttonColors(
            containerColor = GradientTop
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ){
        Text(
            text = text,
            color = White,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}