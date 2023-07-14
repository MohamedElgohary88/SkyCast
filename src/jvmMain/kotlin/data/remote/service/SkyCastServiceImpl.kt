package data.remote.service

import data.remote.HttpRoutes
import data.remote.dto.current.Current
import data.remote.dto.days.ForecastDaysResponse
import data.remote.dto.hour.ForecastHoursResponse
import data.remote.dto.search.SearchItemResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*


class SkyCastServiceImpl(
    private val client: HttpClient
) : SkyCastService {
    override suspend fun getWeather(cityName: String): Current {
        return client.get {
            url(HttpRoutes.getCurrentWeather(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun getCityName(cityName: String): List<SearchItemResponse> {
        return client.get {
            url(HttpRoutes.searchCity(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }


    override suspend fun getForecastDays(cityName: String): ForecastDaysResponse {
        return client.get {
            url(HttpRoutes.getForecastDays(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun getForecastHours(cityName: String): ForecastHoursResponse {
        return client.get {
            url(HttpRoutes.searchCity(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }
}