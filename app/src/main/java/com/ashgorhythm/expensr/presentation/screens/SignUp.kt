package com.ashgorhythm.expensr.presentation.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ashgorhythm.expensr.viewmodel.AuthViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    onSignUpSuccess: () -> Unit,
) {
    val uiState = viewModel.uiState
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SignUp",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {Text("Email")}
        )
        Spacer(modifier = modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = modifier.height(16.dp))
        if (uiState.error != null) Text(uiState.error, color = MaterialTheme.colorScheme.error)
        Button(
            onClick = {
                viewModel.signIn(email,password)
            }
        ) {
            Text("SignUp")
        }
        Spacer(modifier = modifier.height(8.dp))
        LaunchedEffect(uiState.isAuthenticated) {
            if (uiState.isAuthenticated) onSignUpSuccess()
        }
    }
}