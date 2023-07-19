package presentation.home_screen.view_model

import domain.mapper.Mapper
import domain.use_cases.GetCitySearchResultUseCase
import domain.use_cases.GetForecastDayUseCase
import domain.use_cases.GetForecastHourUseCase
import domain.use_cases.GetWeatherDetailsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import presentation.home_screen.view_model.mapper.ForecastDayWeatherUIMapper
import presentation.home_screen.view_model.mapper.ForecastHourUIMapper
import presentation.home_screen.view_model.mapper.SearchUiMapper
import presentation.home_screen.view_model.mapper.WeatherDetailsUiMapper

class HomeViewModel(
    private val weatherDetailsUiMapper: WeatherDetailsUiMapper,
    private val searchUiMapper: SearchUiMapper,
    private val forecastDayWeatherUIMapper: ForecastDayWeatherUIMapper,
    private val forecastHourUIMapper: ForecastHourUIMapper,
    private val getWeatherDetailsUseCase: GetWeatherDetailsUseCase,
    private val getCitySearchResultUseCase: GetCitySearchResultUseCase,
    private val getForecastDayUseCase: GetForecastDayUseCase,
    private val getForecastHourUseCase: GetForecastHourUseCase

) : KoinComponent {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    init {
        reloadData()
    }

    fun reloadData() {
        getForecastDayWeather()
        getForecastHourWeather()
        getWeatherDetails()
        getCitySearchResult()
    }

    fun updateSearchInput(newSearchInput: String) {
        _homeUiState.update { currentState ->
            currentState.copy(searchInput = newSearchInput)
        }
    }

    fun updateCityName(cityName: String) {
        _homeUiState.update { currentState ->
            currentState.copy(cityName = cityName)
        }
    }

    private fun getWeatherDetails() {
        tryToExecute(
            call = { getWeatherDetailsUseCase(homeUiState.value.cityName.toString()) },
            mapper = weatherDetailsUiMapper,
            onSuccess = ::onSuccessWeatherDetails,
            onError = ::onError
        )

    }

    private fun onSuccessWeatherDetails(weatherDetailsUiState: HomeUiState) {
        _homeUiState.update {
            it.copy(
                icon = weatherDetailsUiState.icon,
                cityName = weatherDetailsUiState.cityName,
                citySearchResult = emptyList(),
                forecastDayUiState = emptyList(),
                forecastHourUiState = emptyList(),
                text = weatherDetailsUiState.text,
                cloud = weatherDetailsUiState.cloud,
                temperatureCelsius = weatherDetailsUiState.temperatureCelsius,
                feelsLikeCelsius = weatherDetailsUiState.feelsLikeCelsius,
                localTime = weatherDetailsUiState.localTime
            )
        }
    }

    fun getCitySearchResult() {
        tryToExecuteList(
            call = { getCitySearchResultUseCase(homeUiState.value.searchInput!!) },
            onSuccess = ::onSuccessGetCity,
            mapper = searchUiMapper,
            onError = ::onError
        )
    }

    private fun onSuccessGetCity(searchItemUIState: List<SearchItemUIState>) {
        _homeUiState.update { it.copy(citySearchResult = searchItemUIState) }
        println(" input ${homeUiState.value.searchInput}")
        println(" result ${homeUiState.value.citySearchResult}")
    }

    private fun getForecastDayWeather() {
        tryToExecuteList(
            call = { getForecastDayUseCase(homeUiState.value.cityName.toString()) },
            onSuccess = ::onSuccessForecastDayWeather,
            mapper = forecastDayWeatherUIMapper,
            onError = ::onError
        )
    }

    private fun onSuccessForecastDayWeather(forecastDayUiState: List<ForecastDayUiState>) {
        _homeUiState.update { it.copy(forecastDayUiState = forecastDayUiState) }
    }

    private fun getForecastHourWeather() {
        tryToExecuteList(
            call = { getForecastHourUseCase(homeUiState.value.cityName.toString()) },
            onSuccess = ::onSuccessForecastHourWeather,
            mapper = forecastHourUIMapper,
            onError = ::onError
        )
    }

    private fun onSuccessForecastHourWeather(forecastHourUiState: List<ForecastHourUiState>) {
        _homeUiState.update { it.copy(forecastHourUiState = forecastHourUiState) }
    }

    private fun onError(th: Throwable) {
        val errorMessage = th.message ?: "someThingWentWrong"
        _homeUiState.update {
            it.copy(
                onError = listOf(errorMessage),
            )
        }
    }

    private fun <INPUT, OUTPUT> tryToExecute(
        call: suspend () -> INPUT,
        onSuccess: (OUTPUT) -> Unit,
        mapper: Mapper<INPUT, OUTPUT>,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineScope = CoroutineScope(Dispatchers.IO)
    ) {
        dispatcher.launch {
            try {
                mapper.map(call()).also(onSuccess)
            } catch (th: Throwable) {
                onError(th)
            }
        }
    }

    private fun <INPUT, OUTPUT> tryToExecuteList(
        call: suspend () -> List<INPUT>,
        onSuccess: (List<OUTPUT>) -> Unit,
        mapper: Mapper<INPUT, OUTPUT>,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineScope = CoroutineScope(Dispatchers.IO)
    ) {
        dispatcher.launch {
            try {
                mapper.mapSingle(call()).also(onSuccess)
            } catch (th: Throwable) {
                onError(th)
            }
        }
    }

}