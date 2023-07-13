package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class SkyResponse(
    val current: Current,
    val location: Location,
    val request: Request
)