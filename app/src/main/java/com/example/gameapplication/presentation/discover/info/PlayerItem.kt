package com.example.gameapplication.presentation.discover.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.R
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun PlayerItem(name: String, role: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .background(TextPink, RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box {
            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(30.dp)
                    .background(TextPink, RoundedCornerShape(30.dp))
                    .align(Alignment.TopStart),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    role, fontSize = 9.sp, color = White, textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.Black)
    }
}