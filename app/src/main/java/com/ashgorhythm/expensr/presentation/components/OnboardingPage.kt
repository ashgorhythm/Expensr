package com.ashgorhythm.expensr.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import com.ashgorhythm.expensr.presentation.screens.OnboardingScreen

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
        modifier.fillMaxWidth(),
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
fun OnboardingButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
){
    if (pagerState.currentPage > 0){
        Button(
            onClick = onClick,
            shape = CircleShape
        ) {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft,"Back")
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun FirstScreenPreview(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        PagerScreen(modifier = Modifier, onboardingPage = OnboardingPage.First)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        PagerScreen(modifier = Modifier, onboardingPage = OnboardingPage.First)
    }
}