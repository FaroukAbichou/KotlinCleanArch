package com.faroukabichou.kotlincleanarch.details.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.faroukabichou.kotlincleanarch.details.presentation.component.KcDetailsContent
import com.faroukabichou.kotlincleanarch.details.presentation.event.DetailsScreenEvent
import com.faroukabichou.kotlincleanarch.details.presentation.state.DetailsState
import com.faroukabichou.kotlincleanarch.home.presentation.KcError
import com.faroukabichou.kotlincleanarch.home.presentation.KcLoading

@Composable
fun DetailsScreen(
    state: DetailsState,
    onEvent: (DetailsScreenEvent) -> Unit,
    selectedAudioId: String,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {},
        content = {
            if (state.isLoading) {
                KcLoading()
            } else if (state.isFailure) {
                KcError(
                    message = "Error",
                    retry = {}
                )
            } else {
                KcDetailsContent(
                    state = state,
                    onEvent = onEvent,
                    selectedAudioId = selectedAudioId,
                    paddingValues = it
                )
            }
        }
    )
}