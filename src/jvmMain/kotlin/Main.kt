import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.home.HomeScreen

@Composable
@Preview
fun App() {

    MaterialTheme {

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
        HomeScreen(city="",time="1:2", dayOrNight = "", nowDegree = 0,
            fromDegree = 0, toDegree = 0)
    }
}
