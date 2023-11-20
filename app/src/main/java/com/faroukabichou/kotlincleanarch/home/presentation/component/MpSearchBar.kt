package com.faroukabichou.kotlincleanarch.home.presentation.component

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KcSearchBar(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    onHideSearchBar: () -> Unit = {},

    ) {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchBar(
            modifier = Modifier
                .height(60.dp)
                .align(Alignment.TopCenter),
            query = text,
            onQueryChange = { text = it },
            onSearch = {
                active = false
                // TODO: event
            },
            active = active,
            onActiveChange = {
                active = it
                if (!it) {
                    onHideSearchBar()
                }
            },
            shape = RoundedCornerShape(20.dp),
            placeholder = { Text("search") },
            leadingIcon = { TODO() },
            trailingIcon = { TODO() },
        ) {
            repeat(4 /*Todo get number*/) { idx ->
                        KcTrackCard (
                        state = state,
                onEvent = onEvent,
                navigateToPlayAudio = { },
            )
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(4 /*Todo get number*/){
                KcTrackCard(
                    state = state,
                    onEvent = onEvent,
                    navigateToPlayAudio = {  },
                )
            }
        }
    }
}

@Preview
@Composable
fun SearchBarSamplePreview() {
    KcTheme {
        KcSearchBar(
            state = HomeState(),
            onEvent = {},
            onHideSearchBar = {},
        )
    }
}