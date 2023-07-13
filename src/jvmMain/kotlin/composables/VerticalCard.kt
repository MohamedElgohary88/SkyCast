package composables

import PainterRes
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
    Row(
        modifier = Modifier //todo change that to Transparent but that for now to show it
        .fillMaxWidth().padding(horizontal = 18.dp , vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Column (modifier = Modifier.padding(start = 14.dp)){
                Text(text = day , fontSize = 20.sp  , color = Color.White) //todo change color and font size to design system
                Text(text=weather, fontSize = 16.sp , color = Color(0xB3FFFFFF)) //todo change color and font size  to design system
            }
        }
        Column (modifier = Modifier){
            Text(text = "$toDegree°" , fontSize = 16.sp  , color = Color(0xB3FFFFFF)) //todo change color and font size to design system
            Text(text="$fromDegree°", fontSize = 16.sp , color = Color(0xB3FFFFFF)) //todo change color and font size  to design system
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