package com.ashgorhythm.expensr.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashgorhythm.expensr.R

sealed class OnboardingPage(
    @param:StringRes val title: Int,
    @param:StringRes val description: Int,
    @param:DrawableRes
    val image: Int
) {
    object First: OnboardingPage(
        title = R.string.onboarding_title_1,
        description = R.string.onboarding_desc_1,
        image = R.drawable.track_expense
    )
    object Second: OnboardingPage(
        title = R.string.onboarding_title_2,
        description = R.string.onboarding_desc_2,
        image = R.drawable.budget
    )
    object Third: OnboardingPage(
        title = R.string.onboarding_title_3,
        description = R.string.onboarding_desc_3,
        image = R.drawable.goal
    )
}

@Composable
fun PagerScreen(
    modifier: Modifier,
    onboardingPage: OnboardingPage){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(.6f),
            painter = painterResource(onboardingPage.image),
            contentDescription = "Image"
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(onboardingPage.title),
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = stringResource(onboardingPage.description),
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OnboardingBottomBar(
    modifier: Modifier,
    pagerState: PagerState,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    onFinishClick: () -> Unit,
){
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
                shape = CircleShape
            ) {
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft,"Back")
            }
        }else {
            // Placeholder to keep layout balanced
            Box(modifier = Modifier.size(60.dp))
        }
        if (pagerState.currentPage < 2){
            Button(
                onClick = onNextClick,
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight,"Next")
            }
        }else {
            Button(
                onClick = onFinishClick,
            ) {
                Text("Finish")
            }
        }
    }
}
