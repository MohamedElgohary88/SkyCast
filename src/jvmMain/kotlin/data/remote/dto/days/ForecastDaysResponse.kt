package data.remote.dto.days

data class ForecastDaysResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)