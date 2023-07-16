package presentation.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import presentation.home_screen.view_model.HomeUiState
import presentation.home_screen.view_model.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val state by homeViewModel.homeUiState.collectAsState()
    HomeContent(state = state)
    println(homeViewModel.homeUiState)
}

@Composable
fun HomeContent(state: HomeUiState) {

}