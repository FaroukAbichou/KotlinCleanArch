package com.faroukabichou.kotlincleanarch.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.home.presentation.component.KcHomeContent
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navigateToRecommended: (String) -> Unit,
) {
    Scaffold(
        content = {
            if (state.isLoading) {
                KcLoading()
            } else if (state.isFailure) {
                KcError(
                    message = "Error",
                    retry = { onEvent(HomeEvent.Refresh) }
                )
            } else {
                KcHomeContent(
                    state = state,
                    onEvent = onEvent,
                    paddingValues = it,
                    navigateToRecommended = navigateToRecommended
                )
            }
        }
    )
}

@Composable
fun KcLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.tertiary,
            strokeWidth = 2.dp,
            strokeCap = StrokeCap.Round,
        )
    }
}

@Composable
fun KcError(
    message: String,
    retry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = retry,
            shape = CircleShape,
            modifier = Modifier
                .size(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}