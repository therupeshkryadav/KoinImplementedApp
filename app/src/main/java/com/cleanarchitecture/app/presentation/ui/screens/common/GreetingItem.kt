package com.cleanarchitecture.app.presentation.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cleanarchitecture.app.domain.model.Greeting

@Composable
fun GreetingItem(
    item: Greeting,
    itemTint: Color,
    sendToItemDetails: (Greeting) -> Unit, // Pass the greeting to the detail screen
    modifier: Modifier = Modifier
    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(itemTint)
            .clickable { sendToItemDetails(item) } // Navigate to the detail screen with the clicked item
            .border(width = 1.dp, Color.Black)
            .padding(8.dp)
    ) {
        // Type display
        Box(
            modifier = Modifier
                .width(100.dp)
                .padding(end = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item.type,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.background(Color.White).padding(4.dp)
            )
        }

        // Message display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = item.message,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp
            )
        }
    }
}


// Preview for GreetingItem Composable
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingItem(
        item = Greeting("Hello from Clean Architecture!", "Greeting"),
        itemTint = Color.Black,
        sendToItemDetails = { /* Simulate navigation to ItemDetailScreen */ }
    )
}
