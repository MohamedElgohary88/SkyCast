package data.remote.dto.forecast

import data.remote.dto.base_response.AstroDto
import data.remote.dto.base_response.Day
import data.remote.dto.base_response.Hour

data class ForecastDetails(
    val astro: AstroDto?,
    val date: String?,
    val date_epoch: Int?,
    val day: Day?,
    val hour: List<Hour?>
)