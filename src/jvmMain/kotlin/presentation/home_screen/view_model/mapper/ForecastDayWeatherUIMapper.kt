package presentation.home_screen.view_model.mapper

import domain.entities.forecast.WeatherForecastDayEntity
import domain.mapper.Mapper
import presentation.home_screen.view_model.ForecastDayUiState

class ForecastDayWeatherUIMapper :Mapper<WeatherForecastDayEntity, ForecastDayUiState>{
    override fun map(input: WeatherForecastDayEntity): ForecastDayUiState {
        return ForecastDayUiState(
            icon=input.icon,
            text=input.text,
            maximumTemperatureCelsius=input.maximumTemperatureCelsius,
            minimumTemperatureCelsius = input.minimumTemperatureCelsius,
            date=input.localTime
        )
    }
}