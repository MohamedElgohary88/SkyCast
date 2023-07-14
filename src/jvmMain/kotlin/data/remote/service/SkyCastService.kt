package data.remote.service

import data.remote.dto.current.Current
import data.remote.dto.days.ForecastDaysResponse
import data.remote.dto.hour.ForecastHoursResponse
import data.remote.dto.search.SearchItemResponse
import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.json.*
import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import java.util.logging.Level

/**
 * Created by Mohamed Elgohary on 7/14/2023.*/

interface SkyCastService {
    suspend fun getWeather(cityName: String): Current
    suspend fun getCityName(cityName: String): List<SearchItemResponse>
    suspend fun getForecastDays(cityName: String): ForecastDaysResponse
    suspend fun getForecastHours(cityName: String): ForecastHoursResponse

    companion object {
        fun create(): SkyCastService {
            return SkyCastServiceImpl(
                client = HttpClient(Java) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation) {
                        gson()
                    }
                }
            )
        }
    }
}