package com.example.gameapplication.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar(
    items: List<BottomNavItemData>,
    currentRoute: String?,
    onItemClick: (BottomNavItemData) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    onItemClick(item)
                },
                icon = {},
                label = {
                    Text(item.title)
                }
            )
        }
    }
}