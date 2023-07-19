package presentation.home_screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import presentation.home_screen.view_model.HomeViewModel


@Preview
@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val state by homeViewModel.homeUiState.collectAsState()
    HomeContent(
        state = state,
        updateSearchInput = { newSearchInput ->
            homeViewModel.updateSearchInput(newSearchInput)
        },
        updateCityName = { cityName ->
            homeViewModel.updateCityName(cityName)
        }, reloadData = { homeViewModel.reloadData() },
        getSearchResult = {
            homeViewModel.getCitySearchResult()
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
    }
}