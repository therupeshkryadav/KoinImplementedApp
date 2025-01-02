package com.cleanarchitecture.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.app.presentation.ui.screens.AddScreen
import com.cleanarchitecture.app.presentation.ui.screens.HomeScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemListScreen
import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    // Use GreetingViewModel to manage the list of greetings
    val greetingViewModel: GreetingViewModel = viewModel()

    // Load initial greetings into the ViewModel
    greetingViewModel.loadGreetings()

    // App Start Flow (GreetingScreen to ItemListScreen)
    NavHost(navController, startDestination = Route.HomeScreen.route) {

        // GreetingScreen
        composable(Route.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                itemsList = greetingViewModel.itemsList,
                onAddClick = {
                    navController.navigate(Route.AddScreen.route)
                },
                onItemListClick = {
                    navController.navigate(Route.ItemListScreen.route)
                }
            )
        }

        // AddScreen
        composable(Route.AddScreen.route) {
            AddScreen(
                onAddCompleted = { message, type ->
                    // Add the new item to the list with both message and type using ViewModel
                    greetingViewModel.addGreeting(message, type)
                    navController.popBackStack() // Navigate back to GreetingScreen
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // ItemListScreen
        composable(Route.ItemListScreen.route) {
            ItemListScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                itemsList = greetingViewModel.itemsList // Pass the shared list from ViewModel
            )
        }
    }
}
