package com.cleanarchitecture.app.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cleanarchitecture.app.presentation.navigation.NavGraph
import com.cleanarchitecture.app.presentation.ui.theme.KoinImplementedAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinImplementedAppTheme {
                NavGraph()
            }
        }
    }
}
