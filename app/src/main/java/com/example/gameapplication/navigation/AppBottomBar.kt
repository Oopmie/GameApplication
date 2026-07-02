package com.example.gameapplication.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.White

@Composable
fun AppBottomBar(
    items: List<BottomNavItemData>,
    currentRoute: String?,
    onItemClick: (BottomNavItemData) -> Unit
) {
    NavigationBar(containerColor = GradientTop) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    onItemClick(item)
                },
                icon = { Icon(painterResource(item.icon), contentDescription = null,
                    modifier = Modifier.size(20.dp), tint = White) },
                label = {
                    Text(item.title, color = White)
                }
            )
        }
    }
}