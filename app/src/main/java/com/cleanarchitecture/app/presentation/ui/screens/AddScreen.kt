package com.cleanarchitecture.app.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddScreen(onAddCompleted: (String, String) -> Unit, onBackClick: () -> Unit) {
    val messageText = remember { mutableStateOf("") }
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) } // Control the dropdown visibility
    val selectedType = remember { mutableStateOf("") } // Store selected type
    val typeOptions = listOf("Type 1", "Type 2", "Type 3", "Type 4", "Type 5") // Dropdown options


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add New Item",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Message Input Field
        Text(text = "Message", fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))
        TextField(
            value = messageText.value,
            onValueChange = { messageText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(width = 1.dp, color = Color.LightGray),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            placeholder = { Text(text = "Enter your message") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Dropdown Menu for Type Selection
        Text(
            text = "Type",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        // Type Box - Clickable area to toggle the dropdown
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(width = 1.dp, color = Color.LightGray)
                .padding(16.dp)
                .clickable(
                    indication = null, // Remove ripple effect
                    interactionSource = remember { MutableInteractionSource() } // Provide an interaction source
                ) { expanded = !expanded },
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = if (selectedType.value.isEmpty()) "Select type" else selectedType.value,
                fontSize = 16.sp,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Down",
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        // Dropdown List - Show when expanded is true
        if (expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            ) {
                typeOptions.forEach { type ->
                    Text(
                        text = type,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                selectedType.value = type // Set the selected type
                                expanded = false // Close the dropdown after selection
                            },
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Add Button
        Button(
            onClick = {
                if (messageText.value.isNotBlank() ) {
                    if (selectedType.value.isBlank())
                        selectedType.value = "default"
                    onAddCompleted(messageText.value, selectedType.value)
                    messageText.value = "" // Reset input fields
                    selectedType.value = ""
                }
                else {
                    Toast.makeText(
                        context,
                        "Please enter a message and select a type!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Item", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Back Button
        Button(onClick = { onBackClick() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Back", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    AddScreen(onAddCompleted = { _, _ -> }, onBackClick = {})
}

