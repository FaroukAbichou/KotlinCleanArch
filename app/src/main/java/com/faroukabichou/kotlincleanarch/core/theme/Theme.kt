package com.faroukabichou.kotlincleanarch.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = Purple1,
    onBackground = Purple2,
    secondary = Blue1,
    tertiary = White1,
    onTertiary = Purple3,
    scrim = Pink1,
)

private val LightColorScheme = lightColorScheme(
    background = Purple1,
    onBackground = Purple2,
    secondary = Blue1,
    tertiary = White1,
    onTertiary = Purple3,
    scrim = Pink1,
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
