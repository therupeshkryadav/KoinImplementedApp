package com.cleanarchitecture.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.presentation.ui.screens.AddScreen
import com.cleanarchitecture.app.presentation.ui.screens.GreetingScreen
import com.cleanarchitecture.app.presentation.ui.screens.ItemListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    // Placeholder for a shared list of greetings (in a real scenario, this would come from a ViewModel)
    val itemsList = remember { mutableListOf<Greeting>(
        Greeting("Hello from Clean Architecture!", "Greeting"),
        Greeting("Welcome to Compose!", "Information"),
        Greeting("Enjoy building your app!", "Motivation"),
        Greeting("Hello from Clean Architecture!", "Greeting"),
        Greeting("Welcome to Compose!", "Information"),
        Greeting("Enjoy building your app!", "Motivation"),
        Greeting("Hello from Clean Architecture!", "Greeting"),
        Greeting("Welcome to Compose!", "Information"),
        Greeting("Enjoy building your app!", "Motivation"),
        Greeting("Hello from Clean Architecture!", "Greeting"),
        Greeting("Welcome to Compose!", "Information"),
        Greeting("Enjoy building your app!", "Motivation"),
    ) }

    // App Start Flow (GreetingScreen to ItemListScreen)
    NavHost(navController, startDestination = Route.GreetingScreen.route) {

        // GreetingScreen
        composable(Route.GreetingScreen.route) {
            GreetingScreen(
                itemsList = itemsList,
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
                    // Add the new item to the list with both message and type
                    val newGreeting = Greeting(message = message, type = type)
                    itemsList.add(newGreeting)
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
                itemsList = itemsList // Pass the shared list
            )
        }
    }
}
