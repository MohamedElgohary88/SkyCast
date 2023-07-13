package domain

import data.remote.dto.LocationResponse
import data.remote.dto.SkyCastResponse

interface SkyCastRepository {
    suspend fun getWeather():SkyCastResponse
    suspend fun getCity(name:String): LocationResponse
}