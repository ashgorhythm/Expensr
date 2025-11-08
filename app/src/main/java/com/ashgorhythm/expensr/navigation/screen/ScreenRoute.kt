package com.ashgorhythm.expensr.navigation.screen

const val ONBOARD_ROUTE = "onboard_route"
const val AUTH_ROUTE = "auth_rote"
const val HOME_ROUTE = "home_route"
sealed class ScreenRoute(val route: String) {
    object Home: ScreenRoute("home_screen")
    object Login: ScreenRoute("login_screen")
    object SignUp: ScreenRoute("signup_screen")
    object Onboard: ScreenRoute("onboard_screen")
}