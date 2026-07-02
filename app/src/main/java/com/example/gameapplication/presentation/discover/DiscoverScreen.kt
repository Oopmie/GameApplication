package com.example.gameapplication.presentation.discover

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.AppTypography
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverScreen(
    onBack: () -> Unit,
    onInfoClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            GradientTop,
                            GradientBot
                        )
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {

                IconButton(onClick = onBack) {
                    Icon(
                        painterResource(com.example.gameapplication.R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier.rotate(180f)
                            .size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Discover\nCombats",
                        style = AppTypography.displayMedium,
                        color = White
                    )

                    Text(
                        "FILTER",
                        color = White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = {
                        search = it
                    },
                    placeholder = {
                        Text("Search Combat", color = Color.Gray)
                    },
                    leadingIcon = {
                        Box(
                            modifier = Modifier.size(18.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(com.example.gameapplication.R.drawable.search),
                                contentDescription = null,
                                tint = TextPink
                            )
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White,
                        focusedContainerColor = White,
                        unfocusedIndicatorColor = White,
                        focusedIndicatorColor = White,
                        cursorColor = TextPink
                    )
                )
            }
        }

        DiscoverSection(
            title = "Trending this week"
        )

        repeat(4) {
            CombatCard(
                onClick = onInfoClick
            )
        }

        DiscoverSection(
            title = "Most Popular Players"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PlayerCard()
            PlayerCard()
        }

        DiscoverSection(
            title = "Latest Combats"
        )

        repeat(4) {
            CombatCard(
                onClick = onInfoClick
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}