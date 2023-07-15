package domain.use_cases

import domain.entities.forecast.WeatherForecastDayEntity
import domain.repository.SkyCastRepository

class GetForecastDayUseCase(private val skyCastRepository: SkyCastRepository) {
    suspend operator fun invoke(cityName: String): List<WeatherForecastDayEntity> {
        return skyCastRepository.getForecastDays(cityName)
    }
}