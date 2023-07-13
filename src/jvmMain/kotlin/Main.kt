import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    MaterialTheme {
        Button(onClick = {}) {
            Text("Mimo")
        }
    }
}

fun main() = application {
    val state = rememberWindowState()
   // state.placement = WindowPlacement.Maximized
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}