package com.example.gameapplication.presentation.discover

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun CombatCard(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable { onClick() },
        border = BorderStroke(1.dp, TextPink),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp)
                .background(White)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {
                Image(
                    painterResource(com.example.gameapplication.R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
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
                        "Host", fontSize = 9.sp, color = White, textAlign = TextAlign.Center
                    )
                }
            }

            Text(
                "VS",
                color = TextPink,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Box {
                Image(
                    painterResource(com.example.gameapplication.R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .width(30.dp)
                        .background(TextPink, RoundedCornerShape(30.dp))
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Guest", fontSize = 9.sp, color = White, textAlign = TextAlign.Center
                    )
                }
            }

            Column {
                Text(text = "Game Name:", fontSize = 10.sp)
                Text(
                    "NFS(Rivals 2)",
                    color = TextPink, fontSize = 10.sp
                )
            }

            Column {
                Text("Status:", fontSize = 10.sp)
                Text(
                    "Active",
                    color = Color.Green, fontSize = 10.sp
                )
            }

            Column {
                Text("Winning Price:", fontSize = 10.sp)
                Text(
                    "$4,000",
                    color = TextPink, fontSize = 10.sp
                )
            }
        }
    }
}