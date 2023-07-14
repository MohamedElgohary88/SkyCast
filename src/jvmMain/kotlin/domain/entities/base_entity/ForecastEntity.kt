package domain.entities.base_entity


/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class ForecastEntity(
    val astro: AstroEntity,
    val date: String,
    val date_epoch: Int,
    val day: DayEntity,
    val hour: List<HourEntity>
)
