package presentation.home_screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import presentation.home_screen.view_model.HomeViewModel



class HomeScreen( private val homeViewModel: HomeViewModel): Screen {



    @Composable
    override fun Content() {
        val state by homeViewModel.homeUiState.collectAsState()
        HomeContent(state = state)
    }


}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
    }
}