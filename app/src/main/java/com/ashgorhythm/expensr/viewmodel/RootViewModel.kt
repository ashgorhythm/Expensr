package com.ashgorhythm.expensr.viewmodel

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashgorhythm.expensr.navigation.screen.AUTH_ROUTE
import com.ashgorhythm.expensr.navigation.screen.ONBOARD_ROUTE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class RootViewModel(private val context: Context): ViewModel() {
    private val onboardingViewModel = OnboardingViewModel(context)
    private val _startDestination = MutableStateFlow<String?>(null)
    val startDestination: StateFlow<String?> = _startDestination

    init {
        viewModelScope.launch {
            onboardingViewModel.onboardingCompleted.collect { completed ->
                _startDestination.value = if (completed) AUTH_ROUTE else ONBOARD_ROUTE
            }
        }
    }
}