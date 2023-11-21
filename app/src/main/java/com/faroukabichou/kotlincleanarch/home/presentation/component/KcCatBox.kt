package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun KcCatBox(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navigateToPlayAudio: (String) -> Unit
) {

}

@Preview
@Composable
fun KcCatBoxPreview() {
    KcTheme {
        KcCatBox(
            state = HomeState(),
            onEvent = { },
            navigateToPlayAudio = { }
        )
    }
}