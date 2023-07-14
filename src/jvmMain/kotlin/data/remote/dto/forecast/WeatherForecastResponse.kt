package data.remote.dto.forecast

import data.remote.dto.base_response.CurrentX
import data.remote.dto.base_response.Forecast
import data.remote.dto.base_response.Location

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class WeatherForecastResponse(
    val current: CurrentX,
    val forecasts: List<Forecast>,
    val location: Location
)
