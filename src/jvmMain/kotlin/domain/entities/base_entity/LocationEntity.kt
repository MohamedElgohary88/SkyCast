package domain.entities.base_entity

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class LocationEntity(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
)
