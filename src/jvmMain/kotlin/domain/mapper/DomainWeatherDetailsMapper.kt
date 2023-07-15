package domain.mapper

import data.remote.dto.current.CurrentWeatherRemoteDto
import domain.entities.current.CurrentWeatherEntity

/**
 * Created by Mohamed Elgohary on 7/15/2023.
 */

class DomainWeatherDetailsMapper : Mapper<CurrentWeatherRemoteDto, CurrentWeatherEntity> {
    override fun map(input: CurrentWeatherRemoteDto): CurrentWeatherEntity {
        return CurrentWeatherEntity(
            code = input.current?.condition?.code,
            icon = input.current?.condition?.icon,
            text = input.current?.condition?.text,
            cloud = input.current?.cloud,
            temperatureCelsius = input.current?.temp_c,
            feelsLikeCelsius = input.current?.feelslike_c,
            country = input.location?.country,
            localTime = input.location?.localtime,
            name = input.location?.name,
            region = input.location?.region
        )
    }
}