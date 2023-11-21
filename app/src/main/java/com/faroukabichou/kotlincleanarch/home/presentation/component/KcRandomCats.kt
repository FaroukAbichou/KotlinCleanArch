package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.foundation.layout.*
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
fun KcRandomCats(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navigateToPlayAudio: (String) -> Unit
) {
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
                title = stringResource(id = R.string.see_all),
            )
            KcAction(
                text = stringResource(id = R.string.see_all),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            repeat( 4
                /*todo */
            ) {
                KcTrackCard(
                    state = state,
                    onEvent = onEvent,
                    navigateToPlayAudio = navigateToPlayAudio
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview
@Composable
fun KcRecentlyPlayedSectionPreview() {
    KcTheme {
        KcRandomCats(
            state = HomeState(),
            onEvent = {}
        ) { }
    }
}