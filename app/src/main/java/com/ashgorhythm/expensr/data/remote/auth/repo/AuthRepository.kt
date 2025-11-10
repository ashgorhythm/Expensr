package com.ashgorhythm.expensr.data.remote.auth.repo

import com.ashgorhythm.expensr.data.remote.auth.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo

class AuthRepository {
    suspend fun signUp(email: String,password: String): UserInfo?{
        SupabaseClient.auth.signUpWith(
            Email
        ){
            this.email = email
            this.password = password
        }
        return SupabaseClient.auth.currentUserOrNull()
    }
    suspend fun signIn(email: String,password: String): UserInfo?{
        SupabaseClient.auth.signInWith(
            Email
        ){
            this.email = email
            this.password = password
        }
        return SupabaseClient.auth.currentUserOrNull()
    }
    suspend fun signOut(){
        SupabaseClient.auth.signOut()
    }
    fun getCurrentUser(): UserInfo?{
        return SupabaseClient.auth.currentUserOrNull()
    }
    fun isLoggedIn(): Boolean{
        return getCurrentUser() != null
    }
}