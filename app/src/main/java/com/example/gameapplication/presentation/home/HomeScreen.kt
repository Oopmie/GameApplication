package com.example.gameapplication.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gameapplication.R
import com.example.uikit.AppCard
import com.example.uikit.theme.TextPink
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    username: String,
    onLogout: () -> Unit,
    onNavigate: (String) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet {

                Spacer(Modifier.height(24.dp))

                Text(
                    text = "Stone Stellar",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold
                )

                NavigationDrawerItem(
                    label = { Text("My Profile") },
                    selected = false,
                    onClick = { onNavigate("profile") }
                )

                NavigationDrawerItem(
                    label = { Text("Schedule") },
                    selected = false,
                    onClick = { onNavigate("schedule") }
                )

                NavigationDrawerItem(
                    label = { Text("Statistics") },
                    selected = false,
                    onClick = { onNavigate("statistics") }
                )

                NavigationDrawerItem(
                    label = { Text("Discover Combat") },
                    selected = false,
                    onClick = { onNavigate("discover") }
                )

                NavigationDrawerItem(
                    label = { Text("Chat") },
                    selected = false,
                    onClick = { onNavigate("chat") }
                )

                Divider()

                NavigationDrawerItem(
                    label = { Text("Logout") },
                    selected = false,
                    onClick = {
                        onLogout()
                    }
                )
            }
        }
    ) {

        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(username, fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(painterResource(R.drawable.hamburger),
                                contentDescription = null,
                                tint = TextPink,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                )
            }
        ) { padding ->

            Column(
                modifier = Modifier

                    .padding(padding)
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                AppCard(
                    title = "Schedule",
                    description = "Easily schedule event/games\n" +
                            "then find like minded players for battle. You up for it?",
                    image = painterResource(R.drawable.schedule),
                    painterId = R.drawable.ic_arrow_right,
                    onArrowClick = { onNavigate("schedule") }
                )

                AppCard(
                    title = "Statistics",
                    description = "All data from previous and \n" +
                            "upcoming games can\n" +
                            "be found here ",
                    image = painterResource(R.drawable.statistics),
                    painterId = R.drawable.ic_arrow_right,
                    onArrowClick = { onNavigate("statistics") }
                )

                AppCard(
                    title = "Discover  Combats",
                    description = "Find out what’s new and compete among players with new challenges and earn cash with game points ",
                    image = painterResource(R.drawable.discover),
                    painterId = R.drawable.ic_arrow_right,
                    onArrowClick = { onNavigate("discover") }
                )

                AppCard(
                    title = "Message Players",
                    description = "Found the profile of a player\n" +
                            "that interests you? Start a\n" +
                            "conversation",
                    image = painterResource(R.drawable.chat),
                    painterId = R.drawable.ic_arrow_right,
                    onArrowClick = { onNavigate("chat") }
                )
            }
        }
    }
}