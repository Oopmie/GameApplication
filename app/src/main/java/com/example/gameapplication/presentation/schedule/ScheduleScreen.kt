package com.example.gameapplication.presentation.schedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel,
    onSuccess: () -> Unit
) {

    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Game title") }
        )

        Button(onClick = {
            date = "selected_date" // потом заменим на DatePicker
        }) {
            Text("Pick Date & Time")
        }

        Button(onClick = {
            viewModel.createGame(title, date)
            onSuccess()
        }) {
            Text("Publish")
        }
    }
}