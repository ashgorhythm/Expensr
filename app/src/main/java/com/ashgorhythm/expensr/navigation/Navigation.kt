package com.ashgorhythm.expensr.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ashgorhythm.expensr.presentation.screens.AuthScreen
import com.ashgorhythm.expensr.presentation.screens.OnboardingScreen
import com.ashgorhythm.expensr.viewmodel.OnboardingViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val onboardingVM = remember { OnboardingViewModel(context) }
    val onboardingCompleted by onboardingVM.onboardingCompleted.collectAsState()
    val startKey: NavKey = if (onboardingCompleted) Auth else Onboarding
    val backStack = rememberNavBackStack(

    )
    NavDisplay(
        backStack = backStack,
        entryProvider = {key ->
            when(key){
                is Onboarding -> {
                    NavEntry(
                        key = key
                    ){
                        OnboardingScreen(
                            onClick = {
                                onboardingVM.setCompleted()
                                backStack.add(Auth)
                                backStack.remove(Onboarding)
                            }
                        )
                    }
                }
                is Auth -> {
                    NavEntry(
                        key = key
                    ){
                        AuthScreen()
                    }
                }
                else -> throw RuntimeException("Invalid Key")
            }
        }
    )
}