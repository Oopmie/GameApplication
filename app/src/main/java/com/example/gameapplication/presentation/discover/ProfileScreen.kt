package com.example.gameapplication.presentation.discover

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.R
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.Black
import com.example.uikit.theme.TextPink

@Composable
fun ProfileScreen(
    onBack: ()-> Unit,
    goImage: ()-> Unit,
    goCircle: ()-> Unit,
    onInfoClick: () -> Unit,
    username: String,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
            .padding(20.dp)
            .verticalScroll(ScrollState(0))
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        IconButton (onClick = onBack) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = TextPink,
                modifier = Modifier.rotate(180f)
                    .size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Player\nInformation",
            style = AppTypography.displayMedium,
            color = TextPink
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            border = BorderStroke(1.dp, TextPink),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box{
                    Image(
                        painter = painterResource(R.drawable.avatar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                    )

                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .background(Color.Green, CircleShape)
                            .align(Alignment.TopEnd)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = username,
                    fontWeight = FontWeight.Bold
                )

                Row {
                    Text("Status: ")
                    Text(
                        "Online",
                        color = Color.Green
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Earned:")
                        Text(
                            "$5000",
                            color = TextPink,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row (modifier = Modifier
                        .height(40.dp)
                        .width(1.dp)
                        .background(Color.Gray),
                        ){}

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Staked:")
                        Text(
                            "$2000",
                            color = TextPink,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.crown),
                        contentDescription = null,
                        tint = Color(0xFFF4C73E),
                        modifier = Modifier.size(35.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        "Gold Player",
                        color = Color(0xFFF4C73E),
                        fontSize = 24.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "CATEGORY",
            fontSize = 10.sp,
            color = TextPink
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = goImage,
                border = BorderStroke(1.dp, color = TextPink)) {
                Text("Image", color = Black)
            }

            OutlinedButton(onClick = goCircle,
                border = BorderStroke(1.dp, color = TextPink)) {
                Text("Circles", color = Black)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Player\nCombats",
            style = AppTypography.titleLarge,
            color = TextPink
        )

        Spacer(modifier = Modifier.height(20.dp))

        repeat(3) {
            CombatCard(
                onClick = onInfoClick
            )
        }
    }
}