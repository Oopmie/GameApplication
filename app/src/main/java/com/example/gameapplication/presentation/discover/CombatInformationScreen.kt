package com.example.gameapplication.presentation.discover

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameapplication.presentation.discover.info.MatchCard
import com.example.gameapplication.presentation.discover.info.RewardPositionsRow
import com.example.gameapplication.presentation.discover.info.SectionTitle
import com.example.gameapplication.presentation.discover.info.TimeIntervalCard
import com.example.uikit.AppCheckbox
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

// Определение цветов под дизайн макета
val CardBorderColor = Color(0xFFFCE4EC)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CombatInformationScreen(
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = TextPink
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 100.dp)
            ) {
                Text(
                    text = "Combat\nInformation",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink,
                    lineHeight = 38.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                MatchCard()

                Spacer(modifier = Modifier.height(24.dp))

                SectionTitle(text = "DESCRIPTION")
                Text(
                    text = "Hi players, here's the jerk; I need 6 solid gamers to join me on this quest playing NFS(Rivals 2) you all will be rewarded according to the ya' positions, hits and points. Ready for this challange? Let's rock!!!",
                    fontSize = 14.sp,
                    color = Color.Black,
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                SectionTitle(text = "CATEGORY")
                Text(
                    text = "Image",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                RewardPositionsRow()

                Spacer(modifier = Modifier.height(24.dp))

                TimeIntervalCard()

                Spacer(modifier = Modifier.height(24.dp))

                SectionTitle(text = "REMINDERS")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    var isNotificationEnabled by remember { mutableStateOf(true) }
                    AppCheckbox(
                        checked = isNotificationEnabled,
                        onCheckedChange = {isNotificationEnabled = it }
                    )
                    Text(
                        text = "Notification",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Button(
                onClick = {
                    Toast.makeText(context, "Вы успешно присоединились!", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(containerColor = TextPink),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 24.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = "Join Combat!",
                    color = White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}