package com.ashgorhythm.expensr.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ashgorhythm.expensr.navigation.screen.AUTH_ROUTE
import com.ashgorhythm.expensr.navigation.screen.ONBOARD_ROUTE
import com.ashgorhythm.expensr.viewmodel.OnboardingViewModel

@Composable
fun RootNavGraph(){
    val context = LocalContext.current
    val navHostController = rememberNavController()
    val onboardingViewModel = OnboardingViewModel(context)
    val isOnboardingCompleted by onboardingViewModel.onboardingCompleted.collectAsState()
    NavHost(
        navController = navHostController,
        startDestination = if (isOnboardingCompleted) AUTH_ROUTE else ONBOARD_ROUTE
    ){
        OnboardNavGraph(navHostController)
        AuthNavGraph(navHostController)
    }
}