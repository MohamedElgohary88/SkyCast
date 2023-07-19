package presentation.home_screen.view_model.mapper

import domain.entities.forecast.WeatherForecastHourEntity
import domain.mapper.Mapper
import presentation.home_screen.view_model.ForecastHourUiState

class ForecastHourUIMapper:Mapper<WeatherForecastHourEntity, ForecastHourUiState> {
    override fun map(input: WeatherForecastHourEntity): ForecastHourUiState {
        return ForecastHourUiState(
            icon= input.icon,
            temperatureCelsius=input.temperatureCelsius,
            isDay = input.isDay,
            time=input.time
        )
    }
}