package data.repository

import data.remote.dto.LocationResponse
import data.remote.dto.SkyCastResponse
import domain.SkyCastRepository
import io.ktor.client.*
import io.ktor.client.request.*

class SkyCastRepositoryImpl(
    private val client: HttpClient
) : SkyCastRepository {
    override suspend fun getWeather(): SkyCastResponse {
        return client.get()
    }

    override suspend fun getCity(name: String): LocationResponse {
        TODO("Not yet implemented")
    }

}