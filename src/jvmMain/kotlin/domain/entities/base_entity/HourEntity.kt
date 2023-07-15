package domain.entities.base_entity


/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */

data class HourEntity(
    val cloud: Int?,
    val code: Int?,
    val icon: String?,
    val text: String?,
    val feelsLikeCelsius: Double?,
    val isDay: Int?,
    val temperatureCelsius: Double?,
    val time: String?,
)