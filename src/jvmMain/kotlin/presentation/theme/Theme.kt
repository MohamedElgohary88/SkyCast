package presentation.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf

private val ColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    onSecondary = OnSecondary,
)

val SkyCastCustomColors = staticCompositionLocalOf { CustomColorsPalette() }