package data.remote.dto.hour

data class Hour(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)