package domain.entities.base_entity

import data.remote.dto.base_response.Condition

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class WeatherDetailsEntity(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val temp_c: Double,
    val temp_f: Double,
)
