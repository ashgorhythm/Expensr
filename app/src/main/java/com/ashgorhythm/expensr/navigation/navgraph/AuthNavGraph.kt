package com.ashgorhythm.expensr.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ashgorhythm.expensr.navigation.screen.AUTH_ROUTE
import com.ashgorhythm.expensr.navigation.screen.ScreenRoute
import com.ashgorhythm.expensr.presentation.screens.LoginScreen
import com.ashgorhythm.expensr.presentation.screens.SignUpScreen

fun NavGraphBuilder.AuthNavGraph(
    navHostController: NavHostController
){
    navigation(
        route = AUTH_ROUTE,
        startDestination = ScreenRoute.Login.route
    ){
        composable(route = ScreenRoute.Login.route){
            LoginScreen(navHostController = navHostController)
        }
        composable(ScreenRoute.SignUp.route){
            SignUpScreen(navHostController = navHostController)
        }
    }
}