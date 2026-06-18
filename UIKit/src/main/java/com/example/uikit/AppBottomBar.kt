package com.example.uikit

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar(
    selected: Int,
    onSelected: (Int) -> Unit
) {
    NavigationBar {
        listOf(
            "Home",
            "Games",
            "Stats"
        ).forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == index,
                onClick = {
                    onSelected(index)
                },
                icon = {},
                label = {
                    Text(item)
                }
            )
        }
    }
}