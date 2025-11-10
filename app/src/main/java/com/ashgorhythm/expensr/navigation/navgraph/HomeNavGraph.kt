package com.ashgorhythm.expensr.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ashgorhythm.expensr.navigation.screen.AUTH_ROUTE
import com.ashgorhythm.expensr.navigation.screen.HOME_ROUTE
import com.ashgorhythm.expensr.navigation.screen.ScreenRoute
import com.ashgorhythm.expensr.presentation.screens.HomeScreen
import com.ashgorhythm.expensr.presentation.screens.LoginScreen
import com.ashgorhythm.expensr.presentation.screens.SignUpScreen
import com.ashgorhythm.expensr.viewmodel.AuthViewModel

fun NavGraphBuilder.HomeNavGraph(
    navHostController: NavHostController
){
    navigation(
        route = HOME_ROUTE,
        startDestination = ScreenRoute.Home.route
    ){
        composable(route = ScreenRoute.Home.route){
            HomeScreen()
        }
    }
}