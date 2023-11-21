package com.faroukabichou.kotlincleanarch.home.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.component.KcError
import com.faroukabichou.kotlincleanarch.core.component.KcLoading
import com.faroukabichou.kotlincleanarch.core.component.KcTopBar
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.component.KcHomeContent
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            KcTopBar(
                title = stringResource(R.string.home),
            )
        },
        content = { paddingValues ->
            if (state.isLoading) {
                KcLoading()
            } else if (state.isFailure) {
                KcError(
                    message = "Error",
                    retry = {
                        onEvent(HomeEvent.GetRandomCats)
                    }
                )
            } else {
                KcHomeContent(
                    state = state,
                    onEvent = onEvent,
                    paddingValues = paddingValues,
                )
            }
        }
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    KcTheme {
        HomeScreen(
            state = HomeState(),
            onEvent = {}
        )
    }
}