package com.cleanarchitecture.app.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val typeText = remember { mutableStateOf("") }
    val context = LocalContext.current // Getting the context to show a Toast

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

        // Label and Text Field for entering the message
        Text(text = "Message", fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))
        BasicTextField(
            value = messageText.value,
            onValueChange = { messageText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color.LightGray)
                .padding(16.dp),
            singleLine = true
        )

        // Label and Text Field for entering the type
        Text(text = "Type", fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))
        BasicTextField(
            value = typeText.value,
            onValueChange = { typeText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color.LightGray)
                .padding(16.dp),
            singleLine = true
        )

        // Add Button
        Button(
            onClick = {
                if (messageText.value.isNotBlank() && typeText.value.isNotBlank()) {
                    onAddCompleted(messageText.value, typeText.value) // Pass both message and type
                    messageText.value = "" // Reset message input field
                    typeText.value = "" // Reset type input field
                } else {
                    Toast.makeText(context, "Please enter both message and type!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Add Item", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Back Button
        Button(onClick = { onBackClick() }) {
            Text(text = "Back", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    AddScreen(onAddCompleted = { _, _ -> }, onBackClick = {})
}
