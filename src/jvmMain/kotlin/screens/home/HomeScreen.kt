package screens.home

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
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
import composables.CustomSearchField
import composables.HorizontalCard
import composables.VerticalCard


@Preview
@Composable
fun HomeScreen(
    city: String = "Baghdad",
    time: String = "10:22",
    dayOrNight: String = "AM",
    nowDegree: Int = 27,
    fromDegree: Int = 10,
    toDegree: Int = 15
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = PainterRes.skyCloudBackgroundImage(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(15.dp),
            contentDescription = "Weather image"
        )
        Surface(
            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp, vertical = 32.dp),
            color = Color(0x4F2C485F), //todo change color to design system
            border = BorderStroke(0.dp, Color.Transparent),
            shape = RoundedCornerShape(16.dp),
        ) {}

        /// region lazy
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.align(Alignment.TopEnd).padding(end = 32.dp, top = 32.dp, bottom = 32.dp)
                .clip(shape = RoundedCornerShape(topEnd = 16.dp))
                .background(Color(0x4F859BAC))
        ) {
            item {
                Text(
                    text = "Next Days",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp, top = 16.dp)
                )
            }
            items(6) {
                VerticalCard()
            }
        }
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
                .padding(bottom = 32.dp, start = 32.dp, end = 32.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Today",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ) //todo change color and font size to design system
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(20) {
                    HorizontalCard()
                }
            }
        }

        /// endregion

        /// region design
        Row(
            modifier = Modifier.wrapContentSize().align(Alignment.TopStart)
                .padding(start = 64.dp, top = 200.dp)
        ) {
            Image(
                painter = PainterRes.weatherSunCloudImage(),
                contentDescription = "",
                modifier = Modifier.size(150.dp).padding(end = 48.dp)
            )
            Column(modifier = Modifier.padding(end = 56.dp)) {
                Row {
                    Text(
                        modifier = Modifier,
                        text = "$nowDegree",
                        fontSize = 82.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier,
                        text = "°C",
                        fontSize = 48.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier,
                    text = "$fromDegree°C/$toDegree°C",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
            Column {
                Text(
                    modifier = Modifier,
                    text = "Partly Sunny",
                    fontSize = 36.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    modifier = Modifier,
                    text = "Feels like 30°",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
        }
        CustomSearchField("", {}, Modifier.align(Alignment.TopCenter).padding(top = 108.dp))
        Column(
            modifier = Modifier.fillMaxSize().align(Alignment.TopStart)
                .padding(start = 64.dp, top = 108.dp),
        ) {
            Text(
                modifier = Modifier,
                text = city,
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier,
                text = "$time $dayOrNight",
                fontSize = 24.sp,
                color = Color.White
            )
        }
        /// endregion


    }
}

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