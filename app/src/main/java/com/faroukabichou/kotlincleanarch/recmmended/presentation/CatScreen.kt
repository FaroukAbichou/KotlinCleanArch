package com.faroukabichou.kotlincleanarch.recmmended.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.home.presentation.KcError
import com.faroukabichou.kotlincleanarch.home.presentation.KcLoading
import com.faroukabichou.kotlincleanarch.recmmended.presentation.component.RecommendedContent
import com.faroukabichou.kotlincleanarch.recmmended.presentation.component.RecommendedScreenTopBar
import com.faroukabichou.kotlincleanarch.recmmended.presentation.event.CatScreenEvent
import com.faroukabichou.kotlincleanarch.recmmended.presentation.state.CatState

@Composable
fun CatScreen(
    state: CatState,
    onEvent: (CatScreenEvent) -> Unit,
    selectedAudioId: String,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            RecommendedScreenTopBar(
                title = stringResource(R.string.recommended),
                leadingIcon = R.drawable.shuffle,
                actionIcon = R.drawable.back,
                onAction = navigateBack
            )
        },
        content = {
            if (state.isLoading) {
                KcLoading()
            } else if (state.isFailure) {
                KcError(
                    message = "Error",
                    retry = { onEvent(CatScreenEvent.Refresh) }
                )
            } else {
                RecommendedContent(
                    state = state,
                    onEvent = onEvent,
                    selectedAudioId = selectedAudioId,
                    paddingValues = it
                )
            }
        }
    )
}