package com.cleanarchitecture.app.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import com.cleanarchitecture.app.presentation.ui.screens.common.GreetingItem

@Composable
fun ItemListScreen(
    onBackClick: () -> Unit,
    itemsList: List<Greeting>, // Pass the list dynamically
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        // Title of the screen
        Text(
            text = "Item List",
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Handle empty list
        if (itemsList.isEmpty()) {
            Text(
                text = "No items available.",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.CenterVertically),
                style = TextStyle(color = Color.Gray, fontSize = 18.sp)
            )
        } else {
            // List of items using LazyColumn
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .border(width = 2.dp, color = Color.Black)
            ) {
                items(itemsList) { item ->
                    GreetingItem(item = item) // Using the GreetingItem composable
                }
            }
        }

        // Back button
        Button(
            onClick = { onBackClick() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListScreenPreview() {
    // Sample data for preview
    val sampleItems = listOf(
        Greeting("Hello from Clean Architecture!", "Greeting"),
        Greeting("Welcome to Compose!", "Information"),
        Greeting("Enjoy building your app!", "Motivation")
    )

    ItemListScreen(
        onBackClick = {},
        itemsList = sampleItems
    )
}

@Preview(showBackground = true)
@Composable
fun ItemListScreenEmptyPreview() {
    // Empty list for preview
    ItemListScreen(
        onBackClick = {},
        itemsList = emptyList()
    )
}
