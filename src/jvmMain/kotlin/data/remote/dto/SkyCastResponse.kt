package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class SkyCastResponse(
    val currentResponse: CurrentResponse,
    val locationResponse: LocationResponse,
    val requestResponse: RequestResponse
)