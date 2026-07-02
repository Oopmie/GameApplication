package com.example.gameapplication.presentation.statistics

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uikit.R
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@Composable
fun StatisticsScreen(
    onBack: ()-> Unit,
    viewModel: StatisticsViewModel
) {
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    val totalPlayed = state.circleWins + state.imageWins
    val winPercent =
        if (totalPlayed == 0) 0f
        else (totalPlayed.toFloat() / (totalPlayed + 1)) * 100f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        IconButton (onClick = onBack) {
            Icon(
                painter = painterResource(com.example.gameapplication.R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = TextPink,
                modifier = Modifier.rotate(180f)
                    .size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Statistics",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = TextPink
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(TextPink, Color(0xFFFF2D55))
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Column {
                    Text(
                        "THIS WEEK EARNINGS",
                        color = White
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "$${state.earnings}.00",
                        color = White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(
                    painter = painterResource(com.example.gameapplication.R.drawable.statline),
                    contentDescription = null,
                    modifier = Modifier.width(300.dp)
                        .height(100.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Played Games",
            fontWeight = FontWeight.Bold,
            color = TextPink
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = winPercent / 100f,
                strokeWidth = 24.dp,
                modifier = Modifier.size(220.dp),
                color = TextPink
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "${winPercent.toInt()}",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Text("%")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Scheduled Games",
            fontWeight = FontWeight.Bold,
            color = TextPink
        )

        Spacer(modifier = Modifier.height(20.dp))

        WeeklyBarChart(
            scheduledCount = state.scheduledCount
        )
    }
}