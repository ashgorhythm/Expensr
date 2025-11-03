package com.ashgorhythm.expensr.presentation.screens

import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ashgorhythm.expensr.presentation.components.OnboardingBottomBar
import com.ashgorhythm.expensr.presentation.components.OnboardingPage
import com.ashgorhythm.expensr.presentation.components.PagerScreen
import kotlinx.coroutines.launch

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
                onFinishClick = {}
            )
        }
    ) {
        HorizontalPager(
            state = pagerState
        ) {page ->
            PagerScreen(modifier = Modifier, onboardingPage = pages[page])
        }
    }

}