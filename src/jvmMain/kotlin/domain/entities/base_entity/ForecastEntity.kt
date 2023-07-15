package domain.entities.base_entity


/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class ForecastEntity(
    val date: String?,
    val day: DayEntity?,
    val hour: List<HourEntity?>
)