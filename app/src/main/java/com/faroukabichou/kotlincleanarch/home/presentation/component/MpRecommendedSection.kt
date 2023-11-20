package com.faroukabichou.kotlincleanarch.home.presentation.component

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun KcRecommendedSection(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navigateToRecommended: (String) -> Unit,
) {
    val mediaPlayer = MediaPlayer()

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            KcTitle(
                title = stringResource(id = R.string.recommended),
            )
            KcAction(
                text = stringResource(id = R.string.see_all),
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(4) {
                KcRecommendedCard(
                    state = state,
                    onEvent = onEvent,
                    navigateToRecommended = navigateToRecommended,
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun KcRecommendedSectionPreview() {
    KcTheme {
        KcRecommendedSection(
            state = HomeState(),
            onEvent = {},
        ) { }
    }
}