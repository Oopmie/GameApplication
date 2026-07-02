package com.example.gameapplication.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Image(
                            painterResource(R.drawable.avatar),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
                            Text(
                                text = username,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = TextPink
                            )
                            Row {
                                Icon(
                                    painterResource(R.drawable.crown),
                                    contentDescription = null, tint = Color(0xFFF4C73E),
                                    modifier = Modifier.size(17.dp)
                                )
                                Text("Gold Player", color = Color(0xFFF4C73E))
                            }
                        }
                    }

                    Column {

                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    painterResource(R.drawable.prdr),
                                    contentDescription = null,
                                    tint = TextPink,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = { Text("My Profile") },
                            selected = false,
                            onClick = { onNavigate("profile") }
                        )

                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    painterResource(R.drawable.scheddr),
                                    contentDescription = null,
                                    tint = TextPink,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = { Text("Schedule") },
                            selected = false,
                            onClick = { onNavigate("schedule") }
                        )

                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    painterResource(R.drawable.statdr),
                                    contentDescription = null,
                                    tint = TextPink,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = { Text("Statistics") },
                            selected = false,
                            onClick = { onNavigate("statistics") }
                        )

                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    painterResource(R.drawable.locdr),
                                    contentDescription = null,
                                    tint = TextPink,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = { Text("Discover Combat") },
                            selected = false,
                            onClick = { onNavigate("discover") }
                        )

                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    painterResource(R.drawable.chatdr),
                                    contentDescription = null,
                                    tint = TextPink,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = { Text("Chat") },
                            selected = false,
                            onClick = { onNavigate("chat") }
                        )
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        NavigationDrawerItem(
                            modifier = Modifier.width(180.dp),
                            icon = {
                                Icon(
                                    painterResource(R.drawable.logoutdr),
                                    contentDescription = null,
                                    tint = TextPink,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = { Text("Logout") },
                            selected = false,
                            onClick = { onLogout() }
                        )
                    }
                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Image(
                            painter = painterResource(R.drawable.avatar),
                            contentDescription = null,
                            alignment = Alignment.CenterEnd,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                                .size(35.dp)
                        )
                        Text(
                            username, textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 66.dp)
                        )

                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                painterResource(R.drawable.hamburger),
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
                    image = painterResource(R.drawable.schedulehome),
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
                    image = painterResource(R.drawable.chathome),
                    painterId = R.drawable.ic_arrow_right,
                    onArrowClick = { onNavigate("chat") }
                )
            }
        }
    }
}