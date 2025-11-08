package com.ashgorhythm.expensr.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ashgorhythm.expensr.navigation.screen.ONBOARD_ROUTE
import com.ashgorhythm.expensr.navigation.screen.ScreenRoute
import com.ashgorhythm.expensr.presentation.screens.OnboardingScreen

fun NavGraphBuilder.OnboardNavGraph(
    navHostController: NavHostController
){
    navigation(
        route = ONBOARD_ROUTE,
        startDestination = ScreenRoute.Onboard.route
    ){
        composable(route = ScreenRoute.Onboard.route){
            OnboardingScreen(navHostController)
        }
    }
}