import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import app.di.initKoin
import org.koin.core.Koin
import androidx.compose.ui.window.rememberWindowState
import screens.home.HomeScreen

@Composable
@Preview
fun App(koin: Koin) {
    MaterialTheme {
        HomeScreen(koin.get())
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