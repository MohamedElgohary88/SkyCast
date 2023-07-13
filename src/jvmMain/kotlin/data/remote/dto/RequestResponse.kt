package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RequestResponse(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)