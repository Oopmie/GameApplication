package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.AppRoundedMedium
import com.example.uikit.theme.AppRoundedSmall
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun AppCard(
    title: String,
    description: String,
    image: Painter,
    painterId: Int,
    onArrowClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(GradientTop, GradientBot)
                    )
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // TEXT SIDE
                Column(
                    modifier = Modifier.weight(0.6f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = title,
                        style = AppTypography.titleMedium,
                        color = White
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = description,
                        style = AppTypography.bodySmall,
                        color = White
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    IconButton(
                        onClick = onArrowClick,
                        modifier = Modifier.size(56.dp)
                            .padding(end = 20.dp)

                    ) {
                        Icon(
                            painter = painterResource(id = painterId),
                            contentDescription = null,
                            tint = White,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }

                // IMAGE SIDE
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxHeight(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}