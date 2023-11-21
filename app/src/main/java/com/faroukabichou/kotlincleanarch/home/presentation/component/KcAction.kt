package com.faroukabichou.kotlincleanarch.home.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme


@Composable
fun KcAction(
    text: String,
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onTertiary,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
    )
}

@Preview
@Composable
fun KcActionPreview() {
    KcTheme {
        KcAction(
            text = stringResource(id = R.string.see_all),
        )
    }
}