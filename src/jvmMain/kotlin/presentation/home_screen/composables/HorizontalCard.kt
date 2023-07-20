package presentation.home_screen.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import util.AsyncImage
import util.loadImageBitmap
import presentation.home_screen.view_model.ForecastHourUiState
import presentation.theme.SkyCastCustomColors

@Composable
fun HorizontalCard(
    forecastHourUiState: ForecastHourUiState,
    image: String = "https://github.com/JetBrains/compose-multiplatform/raw/master/artwork/idea-logo.svg",
) {
    val color = SkyCastCustomColors.current
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        backgroundColor = color.card
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${forecastHourUiState.time?.takeLast(5)}",
                fontSize = 20.sp,
                color = Color.White,
                style = androidx.compose.material3.MaterialTheme.typography.labelMedium
            )

            AsyncImage({ loadImageBitmap(image) }, { it }, "",
                Modifier.padding(vertical = 8.dp).size(64.dp)
            )

            Text(
                text = "${forecastHourUiState.temperatureCelsius}°C",
                fontSize = 16.sp,
                color = Color.White,
                style = androidx.compose.material3.MaterialTheme.typography.labelMedium
            )
        }
    }
}