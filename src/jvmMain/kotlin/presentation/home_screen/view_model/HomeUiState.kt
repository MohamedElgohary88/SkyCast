package presentation.home_screen.view_model


data class HomeUiState(
    val icon: String? = "",
    val cityName: String? = "",
    val citySearchResult: List<SearchItemUIState?> = emptyList(),
    val forecastDayUiState: List<ForecastDayUiState?> = emptyList(),
    val forecastHourUiState: List<ForecastHourUiState?> = emptyList(),
    val text: String? = "",
    val cloud: Int? = 0,
    val code: Int?=0,
    val temperatureCelsius: Double? = 0.0,
    val feelsLikeCelsius: Double? = 0.0,
    val localTime: String? = "",
    val onError : List<String> = emptyList(),
)

data class SearchItemUIState(
    val cityName: String? = ""
)

data class ForecastDayUiState(
    val icon: String? = "",
    val text: String? = "",
    val maximumTemperatureCelsius: Double? = 0.0,
    val minimumTemperatureCelsius: Double? = 0.0,
    val date: String? = "",
)

data class ForecastHourUiState(
    val icon: String? = "",
    val temperatureCelsius: Double? = 0.0,
    val time: String? = "",
)