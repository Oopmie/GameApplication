package com.example.uikit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.TextPink

@Composable
fun CombatCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, TextPink),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Scott Brown")
            Text(
                "VS",
                color = TextPink,
                fontWeight = FontWeight.Bold
            )
            Text("Stone Stella")

            Column{
                Text("Game Name:")
                Text(
                    "Halo 5",
                    color = TextPink
                )
            }

            Column {
                Text("Status:")
                Text(
                    "Open",
                    color = TextPink
                )
            }

            Column {
                Text("Winning Price:")
                Text(
                    "$4,000",
                    color = TextPink
                )
            }
        }
    }
}