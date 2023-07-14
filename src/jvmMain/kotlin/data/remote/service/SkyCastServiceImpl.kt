package data.remote.service

import app.util.HttpRoutes
import data.remote.dto.current.CurrentResponseDto
import data.remote.dto.forecast.WeatherForecastResponseDto
import data.remote.dto.search.SearchItemResponseDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*


class SkyCastServiceImpl(
    private val client: HttpClient
) : SkyCastService {
    override suspend fun getWeather(cityName: String): CurrentResponseDto {
        return client.get {
            url(HttpRoutes.getCurrentWeather(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun getCityName(cityName: String): List<SearchItemResponseDto> {
        return client.get {
            url(HttpRoutes.searchCity(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }


    override suspend fun getForecastDays(cityName: String): WeatherForecastResponseDto {
        return client.get {
            url(HttpRoutes.getForecastDays(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun getForecastHours(cityName: String): WeatherForecastResponseDto {
        return client.get {
            url(HttpRoutes.getForecastHours(cityName))
            contentType(ContentType.Application.Json)
        }.body()
    }
}