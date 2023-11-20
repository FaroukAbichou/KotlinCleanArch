package com.faroukabichou.kotlincleanarch.recmmended.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R

@Composable
fun PlayAudioButton(
    isPlaying: (Boolean) -> Unit = {},
    onPlayClick: () -> Unit = {}
) {
    var isSongPlaying by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = CircleShape
            )
            .padding(30.dp)
            .clickable {
                isSongPlaying = !isSongPlaying
                isPlaying(isSongPlaying)
                onPlayClick()
            }
        ,
    ) {
        Image(
            painter = painterResource(
                id = if (isSongPlaying) R.drawable.pause
                else R.drawable.play
            ),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background),
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Preview
@Composable
fun PlayAudioButtonPreview() {
    PlayAudioButton(
        onPlayClick = { },
        isPlaying = { }
    )
}