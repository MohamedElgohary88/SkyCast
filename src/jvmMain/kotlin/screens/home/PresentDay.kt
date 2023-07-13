package screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import composables.CustomSearchField
import composables.HorizontalCard

@Composable
fun PresentDay(
    text: String,
    onSearchValueChanged: (String) -> Unit,
    city: String,
    time: String,
    dayOrNight: String,
    image: Painter = PainterRes.weatherSunCloudImage(),
    fromDegree: Int = 35,
    toDegree: Int = 17,
    nowDegree: Int = 27,
) {
    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f).padding(top = 80.dp, start = 38.dp , bottom = 28.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Column(modifier = Modifier.padding(start = 14.dp)) {
                        Text(
                            text = city,
                            fontSize = 36.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ) //todo change color and font size to design system
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "$time $dayOrNight",
                            fontSize = 24.sp,
                            color = Color.White
                        ) //todo change color and font size  to design system
                    }
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CustomSearchField(
                        value = text,
                        onValueChange = onSearchValueChanged
                    )
                }
            }
            Row(
                modifier = Modifier.padding(top = 40.dp),
                horizontalArrangement = Arrangement.spacedBy(56.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = image,
                    contentDescription = "",
                    modifier = Modifier.size(150.dp)
                )
                Column {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.Bottom) { //todo change color and font size to design system
                            Text(
                                text = "$nowDegree",
                                fontSize = 96.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "°C",
                                fontSize = 64.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "$fromDegree°C/$toDegree°C",
                            fontSize = 24.sp,
                            color = Color.White
                        ) //todo change color and font size  to design system
                    }
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    //todo change color and font size to design system
                    Text(
                        text = "Partly Sunny",
                        fontSize = 36.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Feels like 30°",
                        fontSize = 24.sp,
                        color = Color.White
                    ) //todo change color and font size  to design system
                }
            }
        }
        Column {
            Text(
                text = "Today",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ) //todo change color and font size to design system
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                items(6){
                    HorizontalCard()
                }
            }

        }
    }
}