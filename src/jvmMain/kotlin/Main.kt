import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.remote.dto.current.Current
import data.remote.service.SkyCastService

@Composable
@Preview
fun App() {
    val skyCastService = remember { SkyCastService.create() }
    val cityName = "London"

    val currentWeather by produceState<Current?>(initialValue = null) {
        value = skyCastService.getWeather(cityName)
    }

    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {}) {
                Text("Mimo")
            }
            currentWeather?.let { weather ->
                Text("Temperature: ${weather.current?.temp_c}")
                Text("Humidity: ${weather.current?.humidity}")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
