package com.example.gameapplication.presentation.schedule

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.AppCheckbox
import com.example.uikit.AppTextField
import com.example.uikit.components.AppSelect
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleGameScreen(
    onBackClick: () -> Unit,
    onPublishClick: (gameName: String, category: String, price: String, description: String, notify: Boolean) -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val androidContext = androidx.compose.ui.platform.LocalContext.current

    var gameName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var winningPrice by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isNotificationEnabled by remember { mutableStateOf(true) }

    var fromDate by remember { mutableStateOf("Select Date") }
    var fromTime by remember { mutableStateOf("Select Time") }
    var toDate by remember { mutableStateOf("Select Date") }
    var toTime by remember { mutableStateOf("Select Time") }

    val calendar = remember { Calendar.getInstance() }

    val fromDatePicker = androidx.compose.runtime.remember {
        android.app.DatePickerDialog(
            androidContext,
            { _, year, month, dayOfMonth ->
                val selectedCal = java.util.Calendar.getInstance().apply {
                    set(year, month, dayOfMonth)
                }

                val monthName = selectedCal.getDisplayName(java.util.Calendar.MONTH, java.util.Calendar.SHORT, java.util.Locale.US)?.uppercase() ?: ""
                val dayName = selectedCal.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.SHORT, java.util.Locale.US)?.uppercase() ?: ""

                fromDate = "$dayName, $monthName $dayOfMonth, $year"
            },
            calendar.get(java.util.Calendar.YEAR),
            calendar.get(java.util.Calendar.MONTH),
            calendar.get(java.util.Calendar.DAY_OF_MONTH)
        )
    }
    val fromTimePicker = remember {
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                val amPm = if (hourOfDay < 12) "AM" else "PM"
                val hour = if (hourOfDay % 12 == 0) 12 else hourOfDay % 12
                fromTime = String.format(java.util.Locale.US, "%d:%02d %s", hour, minute, amPm)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        )
    }

    val toDatePicker = androidx.compose.runtime.remember {
        android.app.DatePickerDialog(
            androidContext,
            { _, year, month, dayOfMonth ->
                val selectedCal = java.util.Calendar.getInstance().apply {
                    set(year, month, dayOfMonth)
                }

                val monthName = selectedCal.getDisplayName(java.util.Calendar.MONTH, java.util.Calendar.SHORT, java.util.Locale.US)?.uppercase() ?: ""
                val dayName = selectedCal.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.SHORT, java.util.Locale.US)?.uppercase() ?: ""

                toDate = "$dayName, $monthName $dayOfMonth, $year"
            },
            calendar.get(java.util.Calendar.YEAR),
            calendar.get(java.util.Calendar.MONTH),
            calendar.get(java.util.Calendar.DAY_OF_MONTH)
        )
    }
    val toTimePicker = remember {
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                val amPm = if (hourOfDay < 12) "AM" else "PM"
                val hour = if (hourOfDay % 12 == 0) 12 else hourOfDay % 12
                toTime = String.format(java.util.Locale.US, "%d:%02d %s", hour, minute, amPm)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад",
                            tint = TextPink,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = White)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 28.dp)
                    .padding(bottom = 120.dp)
            ) {
                Text(
                    text = "Schedule Game",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink,
                    modifier = Modifier.padding(vertical = 24.dp)
                )

                AppTextField(
                    value = gameName,
                    onValueChange = { gameName = it },
                    placeholder = "Game Name"
                )

                Spacer(modifier = Modifier.height(20.dp))

                AppSelect(
                    selected = category,
                    items = listOf("circle","image"),
                    onSelect = {category=it},
                    placeholder = "Category"
                )

                Spacer(modifier = Modifier.height(20.dp))

                AppTextField(
                    value = winningPrice,
                    onValueChange = { winningPrice = it },
                    placeholder = "Winning Price"
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "FROM",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DropdownSelector(text = fromDate, onClick = { fromDatePicker.show() })
                    DropdownSelector(text = fromTime, onClick = { fromTimePicker.show() })
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "TO",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DropdownSelector(text = toDate, onClick = { toDatePicker.show() })
                    DropdownSelector(text = toTime, onClick = { toTimePicker.show()})
                }

                Spacer(modifier = Modifier.height(40.dp))

                AppTextField(
                    value = description,
                    onValueChange = { description = it },
                    placeholder = "Description"
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "REMINDERS",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPink,
                        letterSpacing = 1.sp
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { isNotificationEnabled = !isNotificationEnabled }
                    ) {
                        AppCheckbox(
                            checked = isNotificationEnabled,
                            onCheckedChange = { isNotificationEnabled = it }
                        )
                        Text(
                            text = "Notification",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Button(
                onClick = {
                    if (gameName.isBlank()) {
                        Toast.makeText(context, "Please enter game name", Toast.LENGTH_SHORT).show()
                    } else {
                        onPublishClick(gameName, category, winningPrice, description, isNotificationEnabled)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = TextPink),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(bottom = 32.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = "Publish",
                    color = White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}