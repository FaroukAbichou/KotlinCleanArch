package com.faroukabichou.kotlincleanarch.details.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.component.KcError
import com.faroukabichou.kotlincleanarch.core.component.KcLoading
import com.faroukabichou.kotlincleanarch.core.component.KcTopBar
import com.faroukabichou.kotlincleanarch.details.presentation.component.KcDetailsContent
import com.faroukabichou.kotlincleanarch.details.presentation.event.DetailsScreenEvent
import com.faroukabichou.kotlincleanarch.details.presentation.state.DetailsState

@Composable
fun DetailsScreen(
    state: DetailsState,
    onEvent: (DetailsScreenEvent) -> Unit,
    selectedAudioId: String,
) {
    Scaffold(
        topBar = {
            KcTopBar(
                icon = R.drawable.back,
                title = "Details",
            )
        },
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