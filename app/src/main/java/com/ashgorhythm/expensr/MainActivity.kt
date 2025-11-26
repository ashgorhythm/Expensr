package com.ashgorhythm.expensr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.ashgorhythm.expensr.navigation.navgraph.RootNavGraph
import com.ashgorhythm.expensr.ui.theme.ExpensrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        enableEdgeToEdge()
        setContent {
            ExpensrTheme {
                RootNavGraph()
            }
        }
    }
}