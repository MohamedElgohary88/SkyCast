package data.repository

import data.remote.service.SkyCastService
import domain.entities.current.CurrentWeatherEntity
import domain.entities.forecast.WeatherForecastDayEntity
import domain.entities.forecast.WeatherForecastHourEntity
import domain.entities.search.SearchItemEntity
import domain.mapper.DomainForecastDayMapper
import domain.mapper.DomainForecastHourMapper
import domain.mapper.DomainSearchItemMapper
import domain.mapper.DomainWeatherDetailsMapper
import domain.repository.SkyCastRepository
import org.jetbrains.skia.impl.Log

class SkyCastRepositoryImpl(
    private val skyCastService: SkyCastService,
    private val domainWeatherDetailsMapper: DomainWeatherDetailsMapper,
    private val domainSearchItemMapper: DomainSearchItemMapper,
    private val domainForecastDayMapper: DomainForecastDayMapper,
    private val domainForecastHourMapper: DomainForecastHourMapper
) : SkyCastRepository {
    override suspend fun getWeather(cityName: String): CurrentWeatherEntity {
        return domainWeatherDetailsMapper.map(skyCastService.getWeather(cityName))
    }

    override suspend fun getCitySearchResult(cityName: String): List<SearchItemEntity> {
        return domainSearchItemMapper.mapSingle(skyCastService.getCityName(cityName))
    }

    override suspend fun getForecastDays(cityName: String): List<WeatherForecastDayEntity> {
        return domainForecastDayMapper.map(skyCastService.getForecastDays(cityName))
    }

    override suspend fun getForecastHours(cityName: String): List<WeatherForecastHourEntity> {
        return domainForecastHourMapper.map(skyCastService.getForecastHours(cityName))
    }
}