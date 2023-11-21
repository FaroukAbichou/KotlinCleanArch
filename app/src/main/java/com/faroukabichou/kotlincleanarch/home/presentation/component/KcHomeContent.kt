package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.component.KcAction
import com.faroukabichou.kotlincleanarch.core.component.KcTitle
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun KcHomeContent(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    paddingValues: PaddingValues,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 24.dp),
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

        state.cats?.let {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(it.size) {
                    KcCatCard(
                        cat = state.cats[it],
                        onEvent = onEvent,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
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