package presentation.splash_screen

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF01507B)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(300.dp),
            painter = PainterRes.splashScreenImage(),
            contentDescription = "Splash_Screen_Image"
        )
    }
}