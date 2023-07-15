package data.repository

import data.remote.service.SkyCastService
import domain.entities.current.CurrentWeatherEntity
import domain.entities.forecast.WeatherForecastDayEntity
import domain.entities.forecast.WeatherForecastHourEntity
import domain.entities.search.SearchItemEntity
import domain.repository.SkyCastRepository

class SkyCastRepositoryImpl(
    private val skyCastService: SkyCastService
) : SkyCastRepository {
    override suspend fun getWeather(cityName: String): CurrentWeatherEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getCityName(cityName: String): List<SearchItemEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getForecastDays(cityName: String): WeatherForecastDayEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getForecastHours(cityName: String): WeatherForecastHourEntity {
        TODO("Not yet implemented")
    }
}