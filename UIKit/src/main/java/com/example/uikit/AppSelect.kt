package com.example.uikit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.uikit.theme.Black
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSelect(
    selected: String,
    items: List<String>,
    onSelect: (String) -> Unit,
    placeholder: String = "Select"
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox (
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            placeholder = {
                Text(placeholder)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = White,
                unfocusedTextColor = Black,
                focusedContainerColor = White,
                focusedTextColor = Black,
                focusedIndicatorColor = TextPink,
                unfocusedIndicatorColor = TextPink
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = TextPink
                )
            },
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable)
        )

        ExposedDropdownMenu (
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(item)
                    },
                    onClick = {
                        onSelect(item)
                        expanded = false
                    }
                )
            }
        }
    }
}