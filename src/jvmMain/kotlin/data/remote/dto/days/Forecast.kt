package data.remote.dto.days

import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    val current: Current,
    val forecast: ForecastX,
    val location: Location
)