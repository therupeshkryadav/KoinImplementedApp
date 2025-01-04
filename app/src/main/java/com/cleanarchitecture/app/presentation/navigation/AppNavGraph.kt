package com.cleanarchitecture.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.presentation.ui.screens.AddScreen
import com.cleanarchitecture.app.presentation.ui.screens.HomeScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemDetailScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemListScreen
import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    //update

    // Use Koin to inject GreetingViewModel
    val greetingViewModel: GreetingViewModel = koinViewModel()

    // Trigger `loadGreetings` when the AppNavGraph is initialized
    LaunchedEffect(Unit) {
        greetingViewModel.loadGreetings()
    }

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

        composable("item_detail_screen/{message}/{type}/{showDeleteButton}") { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message")
            val type = backStackEntry.arguments?.getString("type")
            val showDeleteButton = backStackEntry.arguments?.getString("showDeleteButton")?.toBoolean() ?: false  // Default to false if null

            ItemDetailScreen(
                item = Greeting(message ?: "", type ?: ""),
                onBackClick = { navController.popBackStack() },
                onEditClick = {},
                onDeleteClick = {},
                showDeleteButton = showDeleteButton // Here, pass the value correctly
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
                navController = navController,
                onBackClick = {
                    navController.popBackStack()
                },
                itemsList = greetingViewModel.greetings.value // Pass the shared list from ViewModel
            )
        }
    }
}
