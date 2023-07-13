package data.remote.dto.days

import kotlinx.serialization.Serializable

@Serializable
data class ForecastX(
    val forecastday: List<Forecastday>
)