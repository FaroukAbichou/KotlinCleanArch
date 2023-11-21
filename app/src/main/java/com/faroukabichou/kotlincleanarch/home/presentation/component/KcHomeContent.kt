package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun KcHomeContent(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    paddingValues: PaddingValues,
) {
    if (state.cats == null) {
        Text(
            text = "No cats",
            modifier = Modifier,
            style = MaterialTheme.typography.displayMedium,
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.cats) { cat ->
                KcCatCard(
                    cat = cat,
                    onEvent = onEvent,
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    KcTheme {
        KcHomeContent(
            state = HomeState(),
            onEvent = { },
            paddingValues = PaddingValues(0.dp),
        )
    }
}