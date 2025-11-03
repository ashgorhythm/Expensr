package com.ashgorhythm.expensr.presentation.screens

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ashgorhythm.expensr.presentation.components.OnboardingPage

@Composable
fun OnboardingScreen(modifier: Modifier){
    val pagerState = rememberPagerState(
        pageCount = {3},
        initialPage = 1
    )
    HorizontalPager(
        state = pagerState
    ){

    }
}