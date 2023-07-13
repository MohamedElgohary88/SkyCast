package composables

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VerticalCard(
    image: Painter = PainterRes.weatherSunCloudImage() ,
    day:String = "Tuseday",
    weather:String = "Rain",
    fromDegree:Int = 6,
    toDegree:Int = 9,
){
    Row(modifier = Modifier.padding(horizontal = 18.dp , vertical = 14.dp)) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Column (modifier = Modifier.padding(start = 14.dp)){
            Text(text = day , fontSize = 20.sp  , color = Color.White) //todo change color and font size to design system
            Text(text=weather, fontSize = 16.sp , color = Color.Gray) //todo change color and font size  to design system
        }
        Column (modifier = Modifier.padding(start = 80.dp)){
            Text(text = "$toDegree°" , fontSize = 20.sp  , color = Color.LightGray) //todo change color and font size to design system
            Text(text="$fromDegree°", fontSize = 16.sp , color = Color.LightGray) //todo change color and font size  to design system
        }

    }
}

@Preview
@Composable
fun VerticalCardPreview(){
    MaterialTheme {
        VerticalCard()
    }
}