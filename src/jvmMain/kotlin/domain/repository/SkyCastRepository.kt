package domain.repository

import domain.entities.current.CurrentWeatherEntity
import domain.entities.forecast.WeatherForecastEntity
import domain.entities.search.SearchItemEntity

interface SkyCastRepository {
    suspend fun getWeather(cityName: String): CurrentWeatherEntity
    suspend fun getCityName(cityName: String): List<SearchItemEntity>
    suspend fun getForecastDays(cityName: String): WeatherForecastEntity
    suspend fun getForecastHours(cityName: String): WeatherForecastEntity
}