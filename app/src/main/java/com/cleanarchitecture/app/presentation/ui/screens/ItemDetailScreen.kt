package com.cleanarchitecture.app.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

@Composable
fun ItemDetailScreen(
    item: Greeting,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
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

        // Box for item details with black border and yellow background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(width = 2.dp, color = Color.Black) // Black border
                .background(Color.Yellow) // Yellow background
                .padding(16.dp) // Padding inside the box
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Display Greeting Message with Magenta color for the tag and Black color for the content
                Text(
                    text = "Message:",
                    style = TextStyle(fontSize = 20.sp, color = Color.Magenta),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = item.message,
                    style = TextStyle(fontSize = 20.sp, color = Color.Black),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Display Type with Magenta color for the tag and Black color for the content
                Text(
                    text = "Type:",
                    style = TextStyle(fontSize = 18.sp, color = Color.Magenta),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = item.type,
                    style = TextStyle(fontSize = 18.sp, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        // Action Buttons (Edit and Delete)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Edit Button
            Button(
                onClick = { onEditClick() },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                Text(
                    text = "Edit",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            // Delete Button
            Button(
                onClick = { onDeleteClick() },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                Text(
                    text = "Delete",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailScreenPreview() {
    ItemDetailScreen(
        item = Greeting("Hello from Clean Architecture!", "Greeting"),
        onBackClick = {},
        onEditClick = {},
        onDeleteClick = {}
    )
}
