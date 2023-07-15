package domain.repository

import domain.entities.current.CurrentWeatherEntity
import domain.entities.forecast.WeatherForecastDayEntity
import domain.entities.forecast.WeatherForecastHourEntity
import domain.entities.search.SearchItemEntity

interface SkyCastRepository {
    suspend fun getWeather(cityName: String): CurrentWeatherEntity
    suspend fun getCitySearchResult(cityName: String): List<SearchItemEntity>
    suspend fun getForecastDays(cityName: String): List<WeatherForecastDayEntity>
    suspend fun getForecastHours(cityName: String): List<WeatherForecastHourEntity>
}