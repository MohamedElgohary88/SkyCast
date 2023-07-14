package data.repository

import data.remote.dto.current.Current
import data.remote.dto.forecast.WeatherForecastResponse
import data.remote.dto.search.SearchItemResponse
import data.remote.service.SkyCastService
import domain.repository.SkyCastRepository

class SkyCastRepositoryImpl(
    private val skyCastService: SkyCastService
) : SkyCastRepository {
    override suspend fun getWeather(cityName: String): Current {
        TODO("Not yet implemented")
    }

    override suspend fun getCityName(cityName: String): List<SearchItemResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getForecastDays(cityName: String): WeatherForecastResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getForecastHours(cityName: String): WeatherForecastResponse {
        TODO("Not yet implemented")
    }

}