package domain.entities.forecast

data class WeatherForecastHourEntity(
    val code: Int?,
    val icon: String?,
    val localTime: String?,
    val isDay: Int?,
    val temperatureCelsius: Double?,
    val time: String?,
    val moonRise: String?,
    val moonSet: String?,
    val sunRise: String?,
    val sunSet: String?
)