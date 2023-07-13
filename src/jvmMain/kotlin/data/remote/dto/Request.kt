package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)