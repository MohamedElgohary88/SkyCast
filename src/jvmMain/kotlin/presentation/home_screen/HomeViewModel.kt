package presentation.home_screen

import domain.use_cases.GetWeatherDetailsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : KoinComponent {
    private val getWeatherDetailsUseCase: GetWeatherDetailsUseCase by inject()

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()
    private val cityName = "London"

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        getWeatherDetails()
        println(getWeatherDetailsUseCase)
    }

    private fun getWeatherDetails() {
        coroutineScope.launch {
            _homeUiState.update {
                val data = getWeatherDetailsUseCase(cityName)
                it.copy(
                    icon = data.icon,
                    cityName = data.name,
                    citySearchResult = emptyList(),
                    forecastDay = emptyList(),
                    forecastHour = emptyList(),
                    text = data.text,
                    cloud = data.cloud,
                    temperatureCelsius = data.temperatureCelsius,
                    feelsLikeCelsius = data.feelsLikeCelsius,
                    localTime = data.localTime
                )
            }
        }
    }

    private fun getCitySearchResult() {}
    private fun getForecastDayWeather() {}
    private fun getForecastHourWeather() {}
}