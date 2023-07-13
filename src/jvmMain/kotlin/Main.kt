import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.*

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