package com.faroukabichou.kotlincleanarch.home.presentation.component

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.audio.domain.Audio
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState


@Composable
fun KcRecommendedCard(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    audio: Audio,
    mediaPlayer: MediaPlayer,
    navigateToRecommended: (String) -> Unit,
) {

    var isAudioPlaying by remember { mutableStateOf(false) }
    Button(
        onClick = { navigateToRecommended(audio.id) },
        modifier = Modifier
            .width(270.dp)
            .height(280.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(20.dp)
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .weight(4f)
                    .padding(
                        10.dp,
                    )
            ) {
                AsyncImage(
                    model = audio.artwork,
                    contentDescription = audio.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxSize()

                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f)
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = audio.title,
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                    )
                    Text(
                        text = audio.artist,
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                    )
                }
                KcIconButton(
                    onClick = {
                        isAudioPlaying = !isAudioPlaying
                        if (isAudioPlaying) {
                            try {
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                        } else {
                        }
//                        onEvent(HomeEvent.InsertAudioToRecentlyPlayed(audio))
                    },
                ) {
                    Image(
                        painter = painterResource(id = if (isAudioPlaying) R.drawable.pause else R.drawable.play),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun KcRecommendedCardPreview() {
    KcTheme {
        KcRecommendedCard(
            state = HomeState(),
            onEvent = {},
            audio = Audio.demoItem,
            mediaPlayer = MediaPlayer(),
            navigateToRecommended = { },
        )
    }
}