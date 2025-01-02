package com.cleanarchitecture.app.presentation.ui.screens

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.presentation.ui.screens.common.GreetingItem

@Composable
fun HomeScreen(
    itemsList: List<Greeting>, // Pass the list dynamically
    onAddClick: () -> Unit,
    onItemListClick: () -> Unit,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(8.dp)
    ) {
        // Title of the screen
        Text(
            text = "Home Screen",
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // List of items using LazyColumn
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .border(width = 2.dp, Color.Black)
        ) {
            items(itemsList) { item ->
                GreetingItem(
                    item = item,
                    sendToItemDetails = {
                        // Navigate to ItemDetailScreen and pass the Greeting item
                    }
                )
            }
        }

        // Action buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Add text button
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 16.dp)
                    .background(color = Color.Red)
                    .clickable { onAddClick() },
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Add text",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }

            // Edit list button
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 16.dp)
                    .background(color = Color.DarkGray)
                    .clickable { onItemListClick() }
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Item List",
                    color = Color.Yellow,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen(
        itemsList = listOf(
            Greeting("Hello from Clean Architecture!", "Greeting"),
            Greeting("Welcome to Compose!", "Information"),
            Greeting("Enjoy building your app!", "Motivation")
        ),
        onAddClick = {},
        onItemListClick = {},
        navController = rememberNavController()
    )
}

