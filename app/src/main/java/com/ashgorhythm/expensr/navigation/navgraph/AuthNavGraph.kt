package com.ashgorhythm.expensr.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ashgorhythm.expensr.navigation.screen.AUTH_ROUTE
import com.ashgorhythm.expensr.navigation.screen.HOME_ROUTE
import com.ashgorhythm.expensr.navigation.screen.ScreenRoute
import com.ashgorhythm.expensr.presentation.screens.LoginScreen
import com.ashgorhythm.expensr.presentation.screens.SignUpScreen
import com.ashgorhythm.expensr.viewmodel.AuthViewModel

fun NavGraphBuilder.AuthNavGraph(
    navHostController: NavHostController,
    viewModel: AuthViewModel
){
    navigation(
        route = AUTH_ROUTE,
        startDestination = ScreenRoute.Login.route
    ){
        composable(route = ScreenRoute.Login.route){
            LoginScreen(
                viewModel = viewModel,
                onSignUpNavigate = {
                    navHostController.navigate(ScreenRoute.SignUp.route)
                },
                onLoginSuccess = {
                    navHostController.navigate(HOME_ROUTE){
                        popUpTo(AUTH_ROUTE){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(ScreenRoute.SignUp.route){
            SignUpScreen(
                viewModel = viewModel,
                onSignUpSuccess = {
                    navHostController.navigate(ScreenRoute.Login.route)
                }
            )
        }
    }
}