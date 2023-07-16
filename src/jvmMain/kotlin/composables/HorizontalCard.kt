package composables

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.home_screen.view_model.ForecastDayUiState
import presentation.home_screen.view_model.ForecastHourUiState

@Composable
fun HorizontalCard(
    forecastHourUiState: ForecastHourUiState,
    image: Painter = PainterRes.weatherSunCloudImage(),
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        backgroundColor = Color(0x4F859BAC) //todo change that to Transparent but that for now to show it
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp , vertical = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "${forecastHourUiState.time?.takeLast(5)} PM" , fontSize = 20.sp  , color = Color.White)//todo change color and font size to design system
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier.padding(vertical = 8.dp).size(32.dp)
            )
            Text(text = "${forecastHourUiState.temperatureCelsius}°C" , fontSize = 16.sp  , color = Color.White)//todo change color and font size to design system
        }
    }
}