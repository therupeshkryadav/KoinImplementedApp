package com.cleanarchitecture.app.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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

@Composable
fun ItemDetailScreen(
    greeting: Greeting,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Back",
                color = Color.Blue,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier.clickable { onBackClick() }
            )
        }

        // Display Greeting Message and Type
        Text(
            text = "Message: ${greeting.message}",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Type: ${greeting.type}",
            style = TextStyle(fontSize = 18.sp, color = Color.Gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailScreenPreview() {
    ItemDetailScreen(
        greeting = Greeting("Hello from Clean Architecture!", "Greeting"),
        onBackClick = {}
    )
}
