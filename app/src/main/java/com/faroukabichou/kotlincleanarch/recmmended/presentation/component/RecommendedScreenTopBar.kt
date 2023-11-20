package com.faroukabichou.kotlincleanarch.recmmended.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.component.KcIconButton


@Composable
fun RecommendedScreenTopBar(
    title: String,
    @DrawableRes actionIcon: Int,
    onAction: () -> Unit,
    @DrawableRes leadingIcon: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
            )
            .padding(horizontal = 10.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            onClick = onAction,
            modifier = Modifier
                .padding(8.dp)
            ,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Image(
                painter = painterResource(id = actionIcon),
                contentDescription = null,
                modifier = Modifier
                    .height(20.dp)
            )
        }
        Text(
            text = title,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
        )
        KcIconButton(
            onClick = {},
        ){
            Image(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun RecommendedScreenTopBarPreview() {
    KcTheme {
        RecommendedScreenTopBar(
            title = "Recommended",
            actionIcon = R.drawable.search,
            onAction = {},
            leadingIcon = R.drawable.shuffle
        )
    }
}