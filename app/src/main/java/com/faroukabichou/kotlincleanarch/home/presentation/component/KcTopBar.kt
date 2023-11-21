package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState

@Composable
fun KcTopBar(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit = {},
    title: String,
    @DrawableRes icon: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
            )
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        AsyncImage(
            model = "profileImage",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )

        Text(
            text = title,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
        )

        KcIconButton(
            onClick = {},
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun KcIconButton(
    onClick: () -> Unit,
    image: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(
                color = MaterialTheme.colorScheme.secondary,
            ),
        contentAlignment = Alignment.Center
    ) {
        image()
    }
}

@Preview
@Composable
fun TopBarPreview() {
    KcTheme {
        KcTopBar(
            state = HomeState(),
            title = "Home",
            icon = R.drawable.back
        )
    }
}