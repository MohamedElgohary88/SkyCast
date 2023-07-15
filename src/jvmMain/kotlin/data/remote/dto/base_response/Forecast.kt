package data.remote.dto.base_response

data class Forecast(
    val astro: AstroDto?,
    val date: String?,
    val date_epoch: Int?,
    val day: Day?,
    val hour: List<Hour?>
)