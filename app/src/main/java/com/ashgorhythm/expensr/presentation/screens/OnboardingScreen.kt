package com.ashgorhythm.expensr.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ashgorhythm.expensr.data.datastore.OnboardingPreferences
import com.ashgorhythm.expensr.presentation.components.OnboardingBottomBar
import com.ashgorhythm.expensr.presentation.components.OnboardingPage
import com.ashgorhythm.expensr.presentation.components.PagerIndicator
import com.ashgorhythm.expensr.presentation.components.PagerScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnboardingScreen(){
    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third,
    )
    val pagerState = rememberPagerState(
        pageCount = {3},
        initialPage = 0
    )
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val onboardingPrefs = remember { OnboardingPreferences(context) }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        bottomBar = {
            OnboardingBottomBar(
                modifier = Modifier,
                pagerState = pagerState,
                onNextClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1, animationSpec = tween(durationMillis = 800))
                    }
                },
                onBackClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1, animationSpec = tween(durationMillis = 800))
                    }
                },
                onFinishClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        onboardingPrefs.saveOnboardingCompleted(true)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState
            ) {page ->
                PagerScreen(modifier = Modifier, onboardingPage = pages[page])
            }
            PagerIndicator(
                pagerState = pagerState,
                pageCount = pages.size,
                modifier = Modifier
            )
        }



    }

}