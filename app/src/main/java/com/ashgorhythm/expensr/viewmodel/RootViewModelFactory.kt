package com.ashgorhythm.expensr.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RootViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RootViewModel::class.java)){
            return RootViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}