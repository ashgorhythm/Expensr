package com.ashgorhythm.expensr.navigation.navgraph

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ashgorhythm.expensr.viewmodel.RootViewModel
import com.ashgorhythm.expensr.viewmodel.RootViewModelFactory

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun RootNavGraph(){
    val context = LocalContext.current
    val navHostController = rememberNavController()
    val rootViewModel: RootViewModel = viewModel(factory = RootViewModelFactory(context))
    val startDestination by rootViewModel.startDestination.collectAsState()
    if (startDestination != null){
        NavHost(
            navController = navHostController,
            startDestination = startDestination!!
        ){
            OnboardNavGraph(navHostController)
            AuthNavGraph(navHostController)
        }
    }

}