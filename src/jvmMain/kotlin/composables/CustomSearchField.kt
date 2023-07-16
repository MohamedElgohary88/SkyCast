package composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun CustomSearchField(
    value:String = "",
    onValueChange:(String)->Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.width(400.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color.Transparent,
        border = BorderStroke(width = 1.5.dp, Color(0x80859BAC))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 8.dp,),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = PainterRes.searchIcon(),
                modifier = Modifier.size(24.dp),
                contentDescription = "",
                tint = Color.White
            )
            BasicTextField(
                modifier = Modifier.padding(start = 20.dp),
                textStyle = TextStyle(
                    color = Color.White
                ),
                value = value,
                onValueChange = onValueChange,
            )
        }
    }
}