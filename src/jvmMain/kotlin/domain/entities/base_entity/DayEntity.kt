package domain.entities.base_entity

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class DayEntity(
    val averageTemperatureCelsius: Double?,
    val code: Int?,
    val icon: String?,
    val text: String?,
    val maximumTemperatureCelsius: Double?,
    val minimumTemperatureCelsius: Double?,
)
