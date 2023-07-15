package presentation.home_screen


data class HomeUiState(
    val icon: String = "",
    val citySearchResult: List<SearchItemUIState> = emptyList(),
    val forecastDay: List<ForecastDay> = emptyList(),
    val forecastHour: List<ForecastHour> = emptyList(),
    val text: String = "",
    val cloud: Int = 0,
    val temperatureCelsius: Double = 0.0,
    val feelsLikeCelsius: Double = 0.0,
    val localTime: String = "",
    val name: String = "",
)

data class SearchItemUIState(
    val cityName: String = ""
)

data class ForecastDay(
    val icon: String = "",
    val text: String = "",
    val maximumTemperatureCelsius: Double = 0.0,
    val minimumTemperatureCelsius: Double = 0.0,
    val date: String = "",
)

data class ForecastHour(
    val icon: String = "",
    val temperatureCelsius: Double = 0.0,
    val time: String = "",
)