package com.example.gameapplication.presentation.discover

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun PlayerCard() {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(100.dp),
        border = BorderStroke(1.dp, TextPink),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(com.example.gameapplication.R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier.size(55.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    "Scott Brown",
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
                Text(
                    "Gold Player",
                    color = Color(0xFFF4C73E),
                    fontSize = 10.sp
                )
                Text("Status: Online", fontSize = 10.sp)
                Text("Category’s: Action, Soccer...", fontSize = 10.sp)
            }
        }
    }
}