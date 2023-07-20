package presentation.home_screen.composables

import PainterRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import presentation.home_screen.view_model.SearchItemUIState

@Composable
fun CustomSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    searchResults: List<SearchItemUIState?>,
    selectedCityName: String?,
    reloadData: () -> Unit,
    updateCityName: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.width(360.dp)) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            color = Color.Transparent,
            border = BorderStroke(width = 1.5.dp, Color(0x80859BAC))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 8.dp),
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
                    modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
                    textStyle = TextStyle(color = Color.White),
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true
                )
            }
        }
        if (searchResults.isNotEmpty() || selectedCityName == null) {
            LazyColumn(
                modifier = Modifier
                    .height(80.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0x4f03b6ff))
            ) {
                items(searchResults) { searchItem ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable {
                                searchItem?.cityName?.let { cityName ->
                                    updateCityName(cityName)
                                    reloadData()
                                }
                            },
                        text = searchItem?.cityName ?: "",
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}

