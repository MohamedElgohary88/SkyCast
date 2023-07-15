package domain.entities.forecast

/**
 * Created by Mohamed Elgohary on 7/15/2023.
 */
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
