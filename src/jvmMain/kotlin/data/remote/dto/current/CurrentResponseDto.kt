package data.remote.dto.current

import data.remote.dto.base_response.CurrentX
import data.remote.dto.base_response.Location
import kotlinx.serialization.Serializable

@Serializable
data class CurrentResponseDto(
    val current: CurrentX,
    val location: Location
)