package data.remote.dto.forecast

import data.remote.dto.base_response.CurrentX
import data.remote.dto.base_response.Forecast
import data.remote.dto.base_response.Location

data class WeatherForecastRemoteDto(
    val current: CurrentX?,
    val forecasts: List<Forecast?>,
    val location: Location?
)
