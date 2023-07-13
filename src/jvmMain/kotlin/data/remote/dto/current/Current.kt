package data.remote.dto.current

import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val current: CurrentX,
    val location: Location
)