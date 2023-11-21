package com.faroukabichou.kotlincleanarch.details.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.faroukabichou.kotlincleanarch.home.presentation.KcError
import com.faroukabichou.kotlincleanarch.home.presentation.KcLoading
import com.faroukabichou.kotlincleanarch.details.presentation.component.RecommendedContent
import com.faroukabichou.kotlincleanarch.details.presentation.event.DetailsScreenEvent
import com.faroukabichou.kotlincleanarch.details.presentation.state.DetailsState

@Composable
fun DetailsScreen(
    state: DetailsState,
    onEvent: (DetailsScreenEvent) -> Unit,
    selectedAudioId: String,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {

        },
        content = {
            if (state.isLoading) {
                KcLoading()
            } else if (state.isFailure) {
                KcError(
                    message = "Error",
                    retry = {

                    }
                )
            } else {
                DetailsContent(
                    state = state,
                    onEvent = onEvent,
                    selectedAudioId = selectedAudioId,
                    paddingValues = it
                )
            }
        }
    )
}