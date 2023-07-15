package data.remote.service

import data.remote.dto.current.CurrentWeatherRemoteDto
import data.remote.dto.forecast.WeatherForecastRemoteDto
import data.remote.dto.search.SearchItemRemoteDto

interface SkyCastService {
    suspend fun getWeather(cityName: String): CurrentWeatherRemoteDto
    suspend fun getCityName(cityName: String): List<SearchItemRemoteDto>
    suspend fun getForecastDays(cityName: String): WeatherForecastRemoteDto
    suspend fun getForecastHours(cityName: String): WeatherForecastRemoteDto

}