package com.cleanarchitecture.app.presentation.navigation

sealed class Route(
    val route: String
) {
    object SplashScreen : Route("splash_screen")
    object LoginScreen : Route(route = "loginScreen")
    object SignUpScreen : Route(route = "signUpScreen")
    object HomeScreen : Route(route = "homeScreen")
    object AddScreen : Route(route = "addScreen")
    object ItemListScreen : Route(route = "itemListScreen")
    object ItemDetailScreen : Route("item_detail_screen/{message}/{type}/{showDeleteButton}") {
        fun createRoute(message: String, type: String, showDeleteButton: Boolean) =
            "item_detail_screen/$message/$type/$showDeleteButton"
    }
}