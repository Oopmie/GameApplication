package com.example.gameapplication.presentation.discover.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RewardPositionsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RewardColumn(title = "1ST POSITION", amount = "$2000")
        RewardColumn(title = "2ND POSITION", amount = "$1000")
        RewardColumn(title = "3RD POSITION", amount = "$500")
        RewardColumn(title = "4TH 5TH 6TH POSITION", amount = "$160")
    }
}