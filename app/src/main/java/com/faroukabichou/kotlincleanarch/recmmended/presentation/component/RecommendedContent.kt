package com.faroukabichou.kotlincleanarch.recmmended.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.recmmended.presentation.event.RecommendedEvent
import com.faroukabichou.kotlincleanarch.recmmended.presentation.state.RecommendedState

@Composable
fun RecommendedContent(
    state: RecommendedState,
    onEvent: (RecommendedEvent) -> Unit,
    selectedAudioId: String,
    paddingValues: PaddingValues
) {
    val scrollState = rememberScrollState()
    var isAudioPlaying by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit){
    }

    LaunchedEffect(Unit) {
        onEvent(RecommendedEvent.GetAudioById(selectedAudioId))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(paddingValues)
            .padding(
                horizontal = 24.dp,
                vertical = 10.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CurrentPlayingAudioCard(state.selectedAudio.audio)
        AudioConfigurationSection(
            isPlaying = { isAudioPlaying = it },
            onPlayClick = {

            },
            onNextClick = {
                // TODO:
            },
            onPreviousClick = {
                // TODO:
            },
            onShuffleClick = {
                // TODO:  
            },
        )
        Slider(value = progress, onValueChange = { progress = it })
        Text(
            text = progress.toString(),
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
        )

        SongsButton { }
    }
}

@Preview
@Composable
fun RecommendedContentPreview() {
    KcTheme {
        RecommendedContent(
            state = RecommendedState(),
            onEvent = {},
            selectedAudioId = "",
            paddingValues = PaddingValues()
        )
    }
}
