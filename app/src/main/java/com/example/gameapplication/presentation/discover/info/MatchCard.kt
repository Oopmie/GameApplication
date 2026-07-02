package com.example.gameapplication.presentation.discover.info

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.presentation.discover.CardBorderColor
import com.example.uikit.theme.TextPink

@Composable
fun MatchCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, CardBorderColor, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "NFS(Rivals 2)",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Status: Open",
                    fontSize = 12.sp,
                    color = TextPink,
                    fontWeight = FontWeight.Medium
                )
            }
            Text(text = "$4000", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextPink)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlayerItem(name = "Scott Brown", role = "Host")
            Text(text = "VS", fontWeight = FontWeight.Bold, color = TextPink, fontSize = 16.sp)
            PlayerItem(name = "Stone Stella", role = "Guest")
            Text(text = "+", fontWeight = FontWeight.Bold, color = TextPink, fontSize = 18.sp)
            PlayerItem(name = "Teslar Fullar", role = "Guest")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            PlayerItem(name = "Shema Laset", role = "Guest")
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = "+", fontWeight = FontWeight.Bold, color = TextPink, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(24.dp))
            PlayerItem(name = "Tobi Dubala", role = "Guest")
        }
    }
}