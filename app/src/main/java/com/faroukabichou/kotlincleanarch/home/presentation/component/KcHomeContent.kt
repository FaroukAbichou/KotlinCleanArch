package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun KcHomeContent(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    paddingValues: PaddingValues,
    navigateToRecommended: (String) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        KcTopBar(
            state = state,
            onEvent = onEvent,
            title = stringResource(R.string.home),
            icon = R.drawable.back
        )
        KcAdCard { }
        KcRecommendedSection(
            state = state,
            onEvent = onEvent,
            navigateToRecommended = navigateToRecommended,
        )
        KcRandomCats(
            state = state,
            onEvent = onEvent
        ) {

        }
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    KcTheme {
        KcHomeContent(
            state = HomeState(),
            onEvent = { },
            paddingValues = PaddingValues(0.dp),
            navigateToRecommended = {}
        )
    }
}