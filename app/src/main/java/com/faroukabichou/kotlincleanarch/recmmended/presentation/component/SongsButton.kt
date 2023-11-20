package com.faroukabichou.kotlincleanarch.recmmended.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faroukabichou.kotlincleanarch.R
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import com.faroukabichou.kotlincleanarch.home.presentation.component.KcIconButton

@Composable
fun SongsButton(
    onClick: () -> Unit
) {
    KcIconButton(
        onClick = onClick,
    ){
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.up),
                contentDescription = null,
                modifier = Modifier
                    .size(14.dp)
            )
            Text(
                text = stringResource(id = R.string.songs),
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
            )
        }
    }
}

@Preview
@Composable
fun SongsButtonPreview() {
    KcTheme {
        SongsButton(
            onClick = { }
        )
    }
}