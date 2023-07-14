package domain.entities.base_entity


/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class HourEntity(
    val cloud: Int,
    val condition: ConditionEntity,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val is_day: Int,
    val temp_c: Double,
    val temp_f: Double,
    val time: String,
)