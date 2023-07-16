package screens.home

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import composables.HorizontalCard
import composables.VerticalCard


@Preview
@Composable
fun HomeScreen(
    city: String = "Baghdad",
    time: String = "10:22",
    dayOrNight: String = "AM",
    nowDegree: Int = 5,
    fromDegree: Int = 10,
    toDegree: Int = 15
) {

    var text by remember { mutableStateOf("Search") }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = PainterRes.skyCloudBackgroundImage(), // here the background main image
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(15.dp),
            contentDescription = "Weather image"
        )
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 48.dp, vertical = 64.dp),
//            color = Color(0x4F2C485F), //todo change color to design system
//            border = BorderStroke(0.dp, Color.Transparent),
//            shape = RoundedCornerShape(16.dp),
//        ) {
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .clip(shape= RoundedCornerShape(topEnd = 16.dp))
                    .background(color = Color(0xFF859BAC).copy(alpha = 0.31f))
//                    .blur(15.dp)
                    .align(Alignment.TopEnd)
                    .padding()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 18.dp, vertical = 18.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)

                ) {
                    item {
                        Text( //todo change color and font to design system
                            text = "Next Days",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.padding(start = 18.dp, top = 18.dp)
                        )
                    }
                    items(7) {
                        VerticalCard()
                    }
                }
            }
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
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$fromDegree°C/$toDegree°C",
                fontSize = 24.sp,
                color = Color.White
            ) //todo change color and font size  to design system
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
            )//todo change color and font size  to design system

            Column(modifier = Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = "Today",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                ) //todo change color and font size to design system
                Spacer(modifier = Modifier.height(20.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(6) {
                        HorizontalCard()
                    }
                }

            }
        }
    }

//}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            city = "", time = "1:2", dayOrNight = "", nowDegree = 0,
            fromDegree = 0, toDegree = 0
        )
    }
}