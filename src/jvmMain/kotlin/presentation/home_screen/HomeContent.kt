package presentation.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch
import presentation.home_screen.view_model.HomeUiState
import java.text.SimpleDateFormat

@Composable
fun HomeContent(state: HomeUiState) {
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
            contentPadding = PaddingValues(16.dp),
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
            items(state.forecastDayUiState) {
                if (it != null) {
                    VerticalCard(it)
                }
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
            val scrollState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyRow(
                state = scrollState,
                modifier = Modifier.draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        coroutineScope.launch {
                            scrollState.scrollBy(-delta)
                        }
                    },
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(state.forecastHourUiState) {
                    if (it != null) {
                        HorizontalCard(it)
                    }
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
            Column(modifier = Modifier.padding(end = 56.dp, top = 16.dp)) {
                Row {
                    Text(
                        modifier = Modifier,
                        text = "${state.temperatureCelsius}",
                        fontSize = 64.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier,
                        text = "°C",
                        fontSize = 32.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                val forecast = state.forecastDayUiState.firstOrNull()
                Text(
                    text = "${forecast?.maximumTemperatureCelsius}°C/${
                        forecast?.minimumTemperatureCelsius
                    }°C",
                    fontSize = 24.sp,
                    color = Color.White
                )

            }
            Column(modifier = Modifier.padding(top = 32.dp)) {
                state.text?.let {
                    Text(
                        modifier = Modifier,
                        text = it,
                        fontSize = 26.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    modifier = Modifier,
                    text = "Feels like ${state.feelsLikeCelsius?.toInt()}C°",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
        CustomSearchField("", {}, Modifier.align(Alignment.TopCenter).padding(top = 108.dp, end = 32.dp))
        Column(
            modifier = Modifier.fillMaxSize().align(Alignment.TopStart)
                .padding(start = 64.dp, top = 108.dp),
        ) {
            state.cityName?.let {
                Text(
                    modifier = Modifier,
                    text = it,
                    fontSize = 36.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            state.localTime?.takeLast(5)?.let {
                Text(
                    text = "$it PM",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

        }
        /// endregion
    }
}