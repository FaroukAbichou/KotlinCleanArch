package com.faroukabichou.kotlincleanarch.details.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.faroukabichou.kotlincleanarch.details.presentation.event.DetailsScreenEvent
import com.faroukabichou.kotlincleanarch.details.presentation.state.DetailsState

@Composable
fun KcDetailsContent(
    state: DetailsState,
    onEvent: (DetailsScreenEvent) -> Unit,
    selectedAudioId: String,
    paddingValues: PaddingValues
) {

}