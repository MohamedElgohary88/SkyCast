package presentation.home_screen

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
import presentation.home_screen.HomeContent
import presentation.home_screen.view_model.HomeViewModel


@Preview
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
) {
    val state by homeViewModel.homeUiState.collectAsState()
    HomeContent(state = state)
    println(homeViewModel.homeUiState)

}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
    }
}