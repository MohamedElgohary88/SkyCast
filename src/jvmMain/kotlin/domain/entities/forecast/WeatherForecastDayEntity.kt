package domain.entities.forecast

data class WeatherForecastDayEntity(
    val code: Int?,
    val icon: String?,
    val text: String?,
    val maximumTemperatureCelsius: Double?,
    val minimumTemperatureCelsius: Double?,
    val localTime: String?,
    val moonRise: String?,
    val moonSet: String?,
    val sunRise: String?,
    val sunSet: String?
)
