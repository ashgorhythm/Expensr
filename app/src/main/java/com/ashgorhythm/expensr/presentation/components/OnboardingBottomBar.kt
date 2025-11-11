package com.ashgorhythm.expensr.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ashgorhythm.expensr.R

@Composable
fun OnboardingBottomBar(
    modifier: Modifier,
    pagerState: PagerState,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    onFinishClick: () -> Unit,
){
    val buttonWidth = 60.dp
    val buttonHeight = 60.dp
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (pagerState.currentPage > 0){
            Button(
                onClick = onBackClick,
                shape = RoundedCornerShape(12.dp),
                modifier = modifier.size(width = buttonWidth, height = buttonHeight)
            ) {
                Icon(painter = painterResource(R.drawable.outline_arrow_back_24),"Back")
            }
        }else {
            // Placeholder to keep layout balanced
            Box(modifier = modifier.size(width = buttonWidth, height = buttonHeight))
        }
        if (pagerState.currentPage < 2){
            Button(
                onClick = onNextClick,
                shape = RoundedCornerShape(12.dp),
                modifier = modifier.size(width = buttonWidth, height = buttonHeight)
            ) {
                Icon(painter = painterResource(R.drawable.outline_arrow_forward_24),"Next")
            }
        }else {
            Button(
                onClick = onFinishClick,
                modifier = modifier.size(width = buttonWidth + 30.dp, height = buttonHeight)
            ) {
                Text("Finish")
            }
        }
    }
}
