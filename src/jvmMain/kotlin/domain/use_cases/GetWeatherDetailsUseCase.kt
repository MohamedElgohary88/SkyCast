package domain.use_cases

import domain.entities.current.CurrentWeatherEntity
import domain.repository.SkyCastRepository

class GetWeatherDetailsUseCase(private val skyCastRepository: SkyCastRepository) {
    suspend operator fun invoke(cityName: String): CurrentWeatherEntity {
        return skyCastRepository.getWeather(cityName)
    }
}