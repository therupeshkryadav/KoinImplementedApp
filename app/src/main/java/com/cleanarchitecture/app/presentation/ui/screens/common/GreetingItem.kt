package com.cleanarchitecture.app.presentation.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.presentation.ui.screens.GreetingScreen

// GreetingItem Composable
@Composable
fun GreetingItem(item: Greeting) {
    // Row for each greeting item
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .border(width = 1.dp, Color.Black)
            .padding(8.dp)
    ) {
        // Box for type (tag) on the left
        Box(
            modifier = Modifier
                .width(100.dp) // Adjust width for type display
                .padding(end = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item.type, // Display the type of the greeting
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.background(Color.White).padding(4.dp)
            )
        }

        // Box for the message content on the right
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = item.message, // Display the message of the greeting
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}

// Preview for GreetingScreen
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingItem(Greeting("Hello from Clean Architecture!", "Greeting"))
}
