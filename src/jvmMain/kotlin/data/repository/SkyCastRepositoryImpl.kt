package data.repository

import data.remote.dto.current.Current
import data.remote.dto.current.CurrentX
import data.remote.dto.search.SearchItem
import domain.SkyCastRepository
import io.ktor.client.*
import io.ktor.client.request.*

class SkyCastRepositoryImpl(
    private val client: HttpClient
) : SkyCastRepository {
    override suspend fun getWeather(): Current {
        return client.get {

        }
    }

    override suspend fun getCity(name: String): SearchItem {
        TODO("Not yet implemented")
    }
}