package com.cleanarchitecture.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.presentation.ui.screens.AddScreen
import com.cleanarchitecture.app.presentation.ui.screens.HomeScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemDetailScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemListScreen
import com.cleanarchitecture.app.presentation.ui.screens.LoginScreen
import com.cleanarchitecture.app.presentation.ui.screens.SignUpScreen
import com.cleanarchitecture.app.presentation.ui.screens.SplashScreen
import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val firebaseAuth = FirebaseAuth.getInstance()

    // Use Koin to inject GreetingViewModel
    val greetingViewModel: GreetingViewModel = koinViewModel()

    // Navigation host
    NavHost(
        navController = navController,
        startDestination = Route.SplashScreen.route // Start from the splash screen
    ) {
        // Splash Screen
        composable(Route.SplashScreen.route) {
            SplashScreen {
                // Determine the next destination based on user authentication
                val nextRoute = if (firebaseAuth.currentUser != null) {
                    Route.HomeScreen.route
                } else {
                    Route.LoginScreen.route
                }
                navController.navigate(nextRoute) {
                    popUpTo(Route.SplashScreen.route) { inclusive = true }
                }
            }
        }

        // Login Screen
        composable(Route.LoginScreen.route) {
            LoginScreen(
                onNavigateToSignUp = { navController.navigate(Route.SignUpScreen.route) }
            )
        }

        // Sign Up Screen
        composable(Route.SignUpScreen.route) {
            SignUpScreen(
                onNavigateToLogin = { navController.popBackStack() }
            )
        }

        // Home Screen
        composable(Route.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                itemsList = greetingViewModel.greetings.value,
                onAddClick = { navController.navigate(Route.AddScreen.route) },
                onItemListClick = { navController.navigate(Route.ItemListScreen.route) }
            )
        }

        // Item Detail Screen
        composable(Route.ItemDetailScreen.route) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message")
            val type = backStackEntry.arguments?.getString("type")
            val showDeleteButton = backStackEntry.arguments?.getString("showDeleteButton")?.toBoolean() ?: false

            ItemDetailScreen(
                item = Greeting(message ?: "", type ?: ""),
                onBackClick = { navController.popBackStack() },
                onEditClick = {},
                onDeleteClick = {},
                showDeleteButton = showDeleteButton
            )
        }

        // Add Screen
        composable(Route.AddScreen.route) {
            AddScreen(
                onAddCompleted = { message, type ->
                    greetingViewModel.addGreeting(message, type)
                    navController.popBackStack()
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        // Item List Screen
        composable(Route.ItemListScreen.route) {
            ItemListScreen(
                navController = navController,
                onBackClick = { navController.popBackStack() },
                itemsList = greetingViewModel.greetings.value
            )
        }
    }
}

