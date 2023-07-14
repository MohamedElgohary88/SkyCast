package data.remote.service

import data.remote.dto.current.CurrentResponseDto
import data.remote.dto.forecast.WeatherForecastResponseDto
import data.remote.dto.search.SearchItemResponseDto

/**
 * Created by Mohamed Elgohary on 7/14/2023.*/

interface SkyCastService {
    suspend fun getWeather(cityName: String): CurrentResponseDto
    suspend fun getCityName(cityName: String): List<SearchItemResponseDto>
    suspend fun getForecastDays(cityName: String): WeatherForecastResponseDto
    suspend fun getForecastHours(cityName: String): WeatherForecastResponseDto

}