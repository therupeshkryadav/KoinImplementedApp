package com.cleanarchitecture.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.app.presentation.ui.screens.AddScreen
import com.cleanarchitecture.app.presentation.ui.screens.HomeScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemListScreen
import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    // Use Koin to inject GreetingViewModel
    val greetingViewModel: GreetingViewModel = koinViewModel()

    // App Start Flow (HomeScreen to ItemListScreen)
    NavHost(navController, startDestination = Route.HomeScreen.route) {

        // HomeScreen
        composable(Route.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                itemsList = greetingViewModel.greetings.value, // Use greetings from ViewModel
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
                    navController.popBackStack() // Navigate back to HomeScreen
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
                itemsList = greetingViewModel.greetings.value // Pass the shared list from ViewModel
            )
        }
    }
}
