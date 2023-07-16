package presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF01507B)
val Secondary = Color(0xFFFFFFFF)
val OnSecondary = Color(0xB3FFFFFF)

@Immutable
data class CustomColorsPalette(
    val primary: Color = Primary,
    val secondary: Color = Secondary,
    val onSecondary: Color = OnSecondary,
)