import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import screens.home.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
    }
}

fun main() = application {
    val state = rememberWindowState()
    state.placement = WindowPlacement.Maximized
    Window(onCloseRequest = ::exitApplication, state = state) {
        App()
        HomeScreen(
            city = "Baghdad", time = "10:22", dayOrNight = "AM", nowDegree = 27,
            fromDegree = 35, toDegree = 17
        )
    }
}