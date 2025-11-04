package com.ashgorhythm.expensr.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("onboard")
class OnboardingPreferences(private val context: Context){
    object PreferenceKeys {
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }
    private val dataStore = context.dataStore
    suspend fun saveOnboardingCompleted(completed: Boolean){
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.ONBOARDING_COMPLETED] = completed
        }
    }
    fun readBoardingCompeted(): Flow<Boolean>{
        return context.dataStore.data
            .map { preferences -> preferences[PreferenceKeys.ONBOARDING_COMPLETED] ?: false }
    }
}