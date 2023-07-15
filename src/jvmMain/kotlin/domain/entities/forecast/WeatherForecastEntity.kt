package domain.entities.forecast

import domain.entities.base_entity.ForecastEntity

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */

data class WeatherForecastEntity(
    val code: Int?,
    val icon: String?,
    val text: String?,
    val cloud: Int?,
    val temp_c: Double?,
    val temp_f: Double?,
    val country: String?,
    val localtime: String?,
    val name: String?,
    val region: String?,
    val forecasts: List<ForecastEntity?>
)