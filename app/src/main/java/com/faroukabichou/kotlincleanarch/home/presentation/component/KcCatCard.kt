package com.faroukabichou.kotlincleanarch.home.presentation.component

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.faroukabichou.kotlincleanarch.cat.domain.Cat
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent

@Composable
fun KcCatCard(
    cat: Cat,
    onEvent: (HomeEvent) -> Unit,
) {
    Button(
        onClick = {
            onEvent(HomeEvent.NavigateToCatDetails(cat.id))
        },
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = cat.url,
            contentDescription = "kittykitty",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .align(Alignment.Bottom)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.background.copy(alpha = 0.6f),
                )
        ) {
            Text(
                text = cat.height.toString(),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
            )
            Text(
                text = cat.width.toString(),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
            )
        }
    }
}

@Preview
@Composable
fun KcRecommendedCardPreview() {
    KcTheme {
        KcCatCard(
            cat = Cat.demoItem,
            onEvent = {},
        )
    }
}