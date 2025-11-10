package com.ashgorhythm.expensr.data.remote.auth

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client: SupabaseClient by lazy {
        createSupabaseClient(
            supabaseUrl = "https://ieylecdslcvgypatafvd.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImlleWxlY2RzbGN2Z3lwYXRhZnZkIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjI2MTYyNTUsImV4cCI6MjA3ODE5MjI1NX0.OrNDwnW8dnscNl1pDz0FnygiJ7axVSOuv7pUQ5CD4BQ"
        ){
            install(Postgrest)
            install(Auth){
                alwaysAutoRefresh = true
                autoLoadFromStorage = true
            }
        }
    }
    val auth = client.auth
}