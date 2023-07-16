package composables

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VerticalCard(
    image: Painter = PainterRes.weatherSunCloudImage(),
    day: String = "Tuseday",
    weather: String = "Rain",
    fromDegree: Int = 6,
    toDegree: Int = 9,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .width(182.dp).clip(shape = RoundedCornerShape(12.dp))
            .background(Color(0x4F859BAC)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier.padding(8.dp).size(24.dp)
        )
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                .weight(4f)
        ) {
            Text(
                text = day,
                fontSize = 16.sp,
                color = Color.White
            ) //todo change color and font size to design system
            Text(
                text = weather,
                fontSize = 12.sp,
                color = Color(0xB3FFFFFF)
            ) //todo change color and font size  to design system
        }
        Divider(color = Color(0xffe0e0e0), modifier = Modifier.height(48.dp).width(1.dp).padding( top = 8.dp, bottom = 8.dp))
        Column(
            modifier = Modifier.padding(end = 8.dp, top = 8.dp, bottom = 8.dp, start = 8.dp)
        ) {
            Text(
                text = "$toDegree°",
                fontSize = 14.sp,
                color = Color(0xB3FFFFFF)
            ) //todo change color and font size to design system
            Text(
                text = "$fromDegree°",
                fontSize = 14.sp,
                color = Color(0xB3FFFFFF)
            ) //todo change color and font size  to design system
        }
    }
}


@Preview
@Composable
fun VerticalCardPreview() {
    MaterialTheme {
        VerticalCard()
    }
}