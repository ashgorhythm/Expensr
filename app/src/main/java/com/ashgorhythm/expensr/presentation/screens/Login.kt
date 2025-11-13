package com.ashgorhythm.expensr.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.ashgorhythm.expensr.R
import com.ashgorhythm.expensr.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    onSignUpNavigate: () -> Unit,
    onLoginSuccess: () -> Unit,
) {
    val uiState = viewModel.uiState
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .size(400.dp),
            painter = painterResource(R.drawable.login),
            contentDescription = "Login"
        )
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Please Login to continue.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = modifier.height(16.dp))
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            label = {Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = modifier.height(8.dp))
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardActions = KeyboardActions(onDone = { onLoginSuccess()})

        )
        Spacer(modifier = modifier.height(16.dp))
        if (uiState.error != null) Text(uiState.error, color = MaterialTheme.colorScheme.error)
        Button(
            modifier = modifier.align(Alignment.CenterHorizontally),
            onClick = {
                viewModel.signIn(email,password)
            }
        ) {
            Text("Login")
        }
        Spacer(modifier = modifier.height(8.dp))
        TextButton(
            modifier = modifier.align(Alignment.CenterHorizontally),
            onClick = onSignUpNavigate
        ) {
            Text("No account?", color = Color.Gray)
            Spacer(modifier = modifier.width(4.dp))
            Text("Sign Up", color = Color.Blue, textDecoration = TextDecoration.Underline)
        }
        LaunchedEffect(uiState.isAuthenticated) {
            if (uiState.isAuthenticated) onLoginSuccess()
        }
    }
}
