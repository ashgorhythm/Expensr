package com.ashgorhythm.expensr.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashgorhythm.expensr.data.datastore.OnboardingPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OnboardingViewModel(context: Context): ViewModel() {
    private val preferences = OnboardingPreferences(context)

    val onboardingCompleted: StateFlow<Boolean> =
        preferences.readBoardingCompeted()
            .stateIn(viewModelScope, SharingStarted.Lazily, false)
    fun setCompleted(){
        viewModelScope.launch {
            preferences.saveOnboardingCompleted(true)
        }
    }
}