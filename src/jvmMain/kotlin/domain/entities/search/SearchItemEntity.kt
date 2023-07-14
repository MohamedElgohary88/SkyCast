package domain.entities.search

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */
data class SearchItemEntity(
    val country: String,
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String
)
