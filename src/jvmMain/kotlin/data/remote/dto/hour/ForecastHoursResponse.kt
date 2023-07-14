package data.remote.dto.hour

data class ForecastHoursResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)