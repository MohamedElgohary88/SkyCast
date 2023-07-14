package domain.entities.current

import domain.entities.base_entity.LocationEntity
import domain.entities.base_entity.WeatherDetailsEntity

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */

data class CurrentWeatherEntity(
    val weatherDetails: WeatherDetailsEntity,
    val location: LocationEntity
)