package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.SuccessBack
import com.example.uikit.theme.White

@Composable
fun SuccessScreen(
    successIc: Int,
    close: Int,
    mainText: String,
    text: String,
    buttonText: String,
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SuccessBack),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onContinue) {
                Image(
                    painterResource(close),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(80.dp),
            verticalArrangement = Arrangement.spacedBy(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(successIc),
                contentDescription = null, modifier = Modifier
                    .size(160.dp)
            )

            Text(
                text = mainText,
                color = White,
                style = AppTypography.displayLarge,
                textAlign = TextAlign.Center
            )

            Text(
                text = text,
                color = White,
                style = AppTypography.bodyMedium,
                textAlign = TextAlign.Center
            )

            AppButton(onClick = onContinue, text = buttonText)
        }
    }
}