import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import app.di.initKoin
import org.koin.core.Koin
import presentation.home_screen.HomeScreen
import presentation.splash_screen.Screen
import presentation.splash_screen.SplashScreen

@Composable
fun App(koin: Koin) {
    MaterialTheme {
        val currentScreen = remember { mutableStateOf(Screen.Splash) }
        when (currentScreen.value) {
            Screen.Splash -> SplashScreen(onSplashComplete = { currentScreen.value = Screen.Home })
            Screen.Home -> HomeScreen(koin.get()).Content()
        }
    }
}
fun main() = application {
    val koin = initKoin()
    val state = rememberWindowState()
    state.placement = WindowPlacement.Maximized
    Window(onCloseRequest = ::exitApplication, state = state) {
        App(koin)
    }
}