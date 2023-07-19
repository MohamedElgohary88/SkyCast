package presentation.splash_screen

import PainterRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import navigation.SharedScreen

class SplashScreen: Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val homeScreen = rememberScreen(SharedScreen.HomeScreen)
        var startAnimation by remember { mutableStateOf(false) }
        val alphaAnim = animateFloatAsState(
            targetValue = if(startAnimation) 1f else 0f,
            animationSpec = tween(durationMillis = 3000)
        )
        LaunchedEffect(key1 = true){
            startAnimation =true
            delay(4000)
            navigator.push(homeScreen)
        }
        SplashContent(alpha=alphaAnim.value)
    }

}

@Preview
@Composable
fun SplashContent(alpha:Float) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF01507B)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(300.dp).alpha(alpha=alpha),
            painter = PainterRes.splashScreenImage(),
            contentDescription = "Splash_Screen_Image"
        )
    }
}

