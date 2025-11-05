package com.ashgorhythm.expensr.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ashgorhythm.expensr.presentation.screens.AuthScreen
import com.ashgorhythm.expensr.presentation.screens.OnboardingScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(Onboarding)
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
                                backStack.add(Auth)
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