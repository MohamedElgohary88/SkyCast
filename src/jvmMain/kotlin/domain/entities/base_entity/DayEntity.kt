package domain.entities.base_entity

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class DayEntity(
    val avgtemp_c: Double,
    val avgtemp_f: Double,
    val condition: ConditionEntity,
    val maxtemp_c: Double,
    val maxtemp_f: Double,
    val mintemp_c: Double,
    val mintemp_f: Double,
)
