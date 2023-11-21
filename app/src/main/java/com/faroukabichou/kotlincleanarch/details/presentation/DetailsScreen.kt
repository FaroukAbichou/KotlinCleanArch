package com.faroukabichou.kotlincleanarch.details.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.component.KcError
import com.faroukabichou.kotlincleanarch.core.component.KcLoading
import com.faroukabichou.kotlincleanarch.core.component.KcTopBar
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.details.presentation.event.DetailsScreenEvent
import com.faroukabichou.kotlincleanarch.details.presentation.state.DetailsState

@Composable
fun DetailsScreen(
    state: DetailsState,
    onEvent: (DetailsScreenEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            KcTopBar(
                icon = R.drawable.back,
                title = "Details",
                onActionButtonClick = {
                    onEvent(DetailsScreenEvent.NavigateBack)
                }
            )
        },
        content = {
            if (state.isLoading) {
                KcLoading()
            } else if (state.isFailure) {
                KcError(
                    message = "Error",
                    retry = {
                        onEvent(DetailsScreenEvent.GetRandomCat)
                    }
                )
            } else {
                AsyncImage(
                    model = state.cat?.url,
                    contentDescription = "kittykitty",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(paddingValues = it)
                        .fillMaxSize()
                )
            }
        }
    )
}

@Preview
@Composable
private fun DetailsScreenPreview() {
    KcTheme {
        DetailsScreen(
            state = DetailsState(),
            onEvent = {}
        )
    }
}