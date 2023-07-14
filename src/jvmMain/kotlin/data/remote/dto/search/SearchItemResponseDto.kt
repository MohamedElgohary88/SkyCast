package data.remote.dto.search

import kotlinx.serialization.Serializable

@Serializable
data class SearchItemResponseDto(
    val country: String,
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String
)