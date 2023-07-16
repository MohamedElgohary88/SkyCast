package data.remote.dto.base_response

import data.remote.dto.forecast.ForecastDetails

data class Forecast(
    val forecastday: List<ForecastDetails>
)