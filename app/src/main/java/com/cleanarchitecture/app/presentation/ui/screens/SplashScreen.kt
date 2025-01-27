package com.cleanarchitecture.app.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {

    // Custom Splash Content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }

    LaunchedEffect(Unit) {
        // Simulate loading or wait for some time (e.g., 2 seconds)
        kotlinx.coroutines.delay(2000)
        onSplashComplete()
    }

}