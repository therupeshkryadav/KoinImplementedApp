package com.cleanarchitecture.app.presentation.navigation

sealed class Route(
    val route: String
) {
    object GreetingScreen : Route(route = "greetingScreen")
    object AddScreen : Route(route = "addScreen")
    object ItemListScreen : Route(route = "ItemlistScreen")
}