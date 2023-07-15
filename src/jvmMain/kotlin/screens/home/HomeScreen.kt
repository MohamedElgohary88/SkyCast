package screens.home

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun HomeScreen(
    // city: String = "Baghdad",
    // time: String = "10:22",
    //  dayOrNight: String = "AM"
) {
    var text by remember { mutableStateOf("Search") }
    Box {
        Image(
            painter = PainterRes.skyCloudBackgroundImage(), // here the background main image
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(15.dp),
            contentDescription = ""
        )
        Surface(
            modifier = Modifier.padding(45.dp),
            color = Color(0x4F2C485F), //todo change color to design system
            border = BorderStroke(0.dp, Color.Transparent),
            shape = RoundedCornerShape(16.dp),
        ) {

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}