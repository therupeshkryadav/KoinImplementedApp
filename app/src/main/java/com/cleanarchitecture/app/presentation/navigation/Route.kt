package com.cleanarchitecture.app.presentation.navigation

sealed class Route(
    val route: String
) {
    object HomeScreen : Route(route = "homeScreen")
    object AddScreen : Route(route = "addScreen")
    object ItemListScreen : Route(route = "itemListScreen")
}