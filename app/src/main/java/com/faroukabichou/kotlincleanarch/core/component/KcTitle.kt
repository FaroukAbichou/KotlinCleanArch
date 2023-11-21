package com.faroukabichou.kotlincleanarch.core.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme


@Composable
fun KcTitle(
    title: String,
) {
    Text(
        text = title,
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier
    )
}
@Preview
@Composable
fun KcTitlePreview() {
    KcTheme {
        KcTitle(
            title = stringResource(id = R.string.home),
        )
    }
}
