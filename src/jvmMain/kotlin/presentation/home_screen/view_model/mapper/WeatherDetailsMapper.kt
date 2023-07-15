package presentation.home_screen.view_model.mapper

import domain.entities.current.CurrentWeatherEntity
import domain.mapper.Mapper
import presentation.home_screen.view_model.HomeUiState

class WeatherDetailsMapper :Mapper<CurrentWeatherEntity, HomeUiState> {
    override fun map(input: CurrentWeatherEntity): HomeUiState {
        return HomeUiState(
            code = input.code,
            icon=input.icon,
            text=input.text,
            cloud=input.cloud,
            temperatureCelsius=input.temperatureCelsius,
            cityName = input.name,
            feelsLikeCelsius=input.feelsLikeCelsius,
            localTime=input.localTime
        )
    }
}