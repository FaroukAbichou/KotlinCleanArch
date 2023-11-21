package com.faroukabichou.kotlincleanarch.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = DarkPurple,
    onBackground = Beige,
    primary = BrightPurple,
    secondary = Gray,
)

private val LightColorScheme = lightColorScheme(
    background = Beige,
    onBackground = DarkPurple,
    primary = Gray,
    secondary = BrightPurple,
)

@Composable
fun KcTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    lightColorScheme: ColorScheme = LightColorScheme,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
