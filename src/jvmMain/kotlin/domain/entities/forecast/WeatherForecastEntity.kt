package domain.entities.forecast

import domain.entities.base_entity.ForecastEntity
import domain.entities.base_entity.LocationEntity
import domain.entities.base_entity.WeatherDetailsEntity

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */

data class WeatherForecastEntity(
    val current: WeatherDetailsEntity,
    val forecasts: List<ForecastEntity>,
    val location: LocationEntity
)