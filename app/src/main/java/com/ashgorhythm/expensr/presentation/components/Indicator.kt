package com.ashgorhythm.expensr.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    pagerState: PagerState,
    pageCount: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(0xFF6200EE),
    inactiveColor: Color = Color.Gray,
    dotSize: Dp = 10.dp,
    spacing: Dp = 8.dp
){
    Row(
        modifier = modifier
            .size((dotSize + spacing)*3),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        repeat(pageCount) {index ->
            val isActive = index == pagerState.currentPage
            val animatedWidth by animateDpAsState(
                targetValue = if (isActive) dotSize * 2 else dotSize,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            val animatedHeight by animateDpAsState(
                targetValue = dotSize,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            Box(
                modifier = Modifier
                    .size(height = animatedHeight, width = animatedWidth)
                    .background(color = if (isActive) activeColor else inactiveColor, shape = CircleShape)
            )
        }

    }
}