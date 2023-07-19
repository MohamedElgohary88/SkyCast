import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import app.di.initKoin
import org.koin.core.Koin
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import navigation.SharedScreen
import presentation.home_screen.HomeScreen
import presentation.splash_screen.SplashScreen

@Composable
@Preview
fun App(koin: Koin) {
    MaterialTheme {
        Navigator(SplashScreen())
        ScreenRegistry {
            register<SharedScreen.HomeScreen> {
                HomeScreen(koin.get())
            }
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

