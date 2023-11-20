package com.faroukabichou.kotlincleanarch.recmmended.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.component.KcIconButton

@Composable
fun AudioConfigurationSection(
    onShuffleClick: () -> Unit = {},
    onPreviousClick: () -> Unit = {},
    isPlaying: (Boolean) -> Unit = {},
    onPlayClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onRepeatClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        KcIconButton(
            onClick = onRepeatClick,
        ){
            Image(
                painter = painterResource(id = R.drawable.replay),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        KcIconButton(
            onClick = onPreviousClick,
        ){
            Image(
                painter = painterResource(id = R.drawable.previous),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        PlayAudioButton(
            isPlaying = { isSongPlaying  -> isPlaying(isSongPlaying) },
            onPlayClick = onPlayClick
        )

        KcIconButton(
            onClick = onNextClick,
        ){
            Image(
                painter = painterResource(id = R.drawable.next),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        KcIconButton(
            onClick = onShuffleClick,
        ){
            Image(
                painter = painterResource(id = R.drawable.shuffle),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun AudioConfigurationSectionPreview() {
    KcTheme {
        AudioConfigurationSection()
    }
}
