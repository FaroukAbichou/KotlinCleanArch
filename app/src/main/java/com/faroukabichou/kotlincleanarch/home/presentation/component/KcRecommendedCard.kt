@file:JvmName("KcRecommendedCardKt")

package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun KcRecommendedCard(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navigateToRecommended: (String) -> Unit,
) {
    Button(
        onClick = {},
        modifier = Modifier
            .width(270.dp)
            .height(280.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(20.dp)
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .weight(4f)
                    .padding(10.dp)
            ) {
                AsyncImage(
                    model = "",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxSize()

                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f)
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "title",
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                    )
                    Text(
                        text = "author",
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                    )
                }
                KcIconButton(
                    onClick = {},
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun KcRecommendedCardPreview() {
    KcTheme {
        KcRecommendedCard(
            state = HomeState(),
            onEvent = {},
            navigateToRecommended = { },
        )
    }
}