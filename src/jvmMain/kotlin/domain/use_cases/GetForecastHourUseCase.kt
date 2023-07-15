package domain.use_cases

import domain.entities.forecast.WeatherForecastHourEntity
import domain.repository.SkyCastRepository

class GetForecastHourUseCase(private val skyCastRepository: SkyCastRepository) {
    suspend operator fun invoke(cityName: String): List<WeatherForecastHourEntity> {
        return skyCastRepository.getForecastHours(cityName)
    }
}