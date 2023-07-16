package domain.use_cases

import app.util.HttpRoutes
import domain.entities.forecast.WeatherForecastDayEntity
import domain.repository.SkyCastRepository
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class GetForecastDayUseCase(private val skyCastRepository: SkyCastRepository) {
    suspend operator fun invoke(cityName: String): List<WeatherForecastDayEntity> {
        print(" domain ---> ${skyCastRepository.getForecastDays(cityName)}")
        return skyCastRepository.getForecastDays(cityName)
    }
}