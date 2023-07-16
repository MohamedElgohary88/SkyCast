package domain.mapper

import data.remote.dto.forecast.WeatherForecastRemoteDto
import domain.entities.forecast.WeatherForecastDayEntity

class DomainForecastDayMapper : Mapper<WeatherForecastRemoteDto, List<WeatherForecastDayEntity>> {
    override fun map(input: WeatherForecastRemoteDto): List<WeatherForecastDayEntity> {
        return input.forecast.forecastday.map { forecast ->
            val day = forecast.day
            val astro = forecast.astro
            WeatherForecastDayEntity(
                code = day?.condition?.code,
                icon = day?.condition?.icon,
                text = day?.condition?.text,
                maximumTemperatureCelsius = day?.maxtemp_c,
                minimumTemperatureCelsius = day?.mintemp_c,
                localTime = input.location?.localtime,
                moonRise = astro?.moonrise,
                moonSet = astro?.moonset,
                sunRise = astro?.sunrise,
                sunSet = astro?.sunset
            )
        }
    }
}





