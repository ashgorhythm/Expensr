package com.ashgorhythm.expensr.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashgorhythm.expensr.data.remote.auth.SupabaseClient
import com.ashgorhythm.expensr.data.remote.auth.repo.AuthRepository
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
    private val repository = AuthRepository()
    var uiState by mutableStateOf(AuthUiState())
        private set
    init {
        val user = repository.getCurrentUser()
        uiState = AuthUiState(
            isAuthenticated = user != null,
            userInfo = user
        )
    }

    fun signUp(email: String,password: String){
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                error = null
            )
            try {
                val user = repository.signUp(email,password)
                uiState = uiState.copy(
                    isLoading = false,
                    isAuthenticated = user != null,
                    userInfo = user
                )
            } catch (e: Exception){
                uiState = uiState.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
    fun signIn(email: String,password: String){
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                error = null
            )
            try {
                val user = repository.signIn(email,password)
                uiState = uiState.copy(
                    isLoading = false,
                    isAuthenticated = user != null,
                    userInfo = user
                )
            } catch (e: Exception){
                uiState = uiState.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
    fun signOut(){
        viewModelScope.launch {
            try {
                repository.signOut()
                uiState = AuthUiState()
            } catch (e: Exception){
                uiState = uiState.copy(
                    error = e.message
                )
            }
        }
    }
}

data class AuthUiState(
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val userInfo: UserInfo? = null,
    val error: String? = null
)