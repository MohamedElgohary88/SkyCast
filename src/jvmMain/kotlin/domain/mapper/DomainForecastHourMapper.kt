package domain.mapper

import data.remote.dto.forecast.WeatherForecastRemoteDto
import domain.entities.forecast.WeatherForecastHourEntity

class DomainForecastHourMapper : Mapper<WeatherForecastRemoteDto, List<WeatherForecastHourEntity>> {
    override fun map(input: WeatherForecastRemoteDto): List<WeatherForecastHourEntity> {
        return input.forecast.forecastday.flatMap { forecast ->
            val astro = forecast.astro
            forecast.hour.mapNotNull { hour ->
                WeatherForecastHourEntity(
                    code = hour?.condition?.code,
                    icon = hour?.condition?.icon,
                    isDay = hour?.is_day,
                    time = hour?.time,
                    temperatureCelsius = hour?.temp_c,
                    localTime = input.location?.localtime,
                    moonRise = astro?.moonrise,
                    moonSet = astro?.moonset,
                    sunRise = astro?.sunrise,
                    sunSet = astro?.sunset
                )
            }
        }
    }
}

