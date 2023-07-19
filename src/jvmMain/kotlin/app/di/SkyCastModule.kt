package app.di

import data.remote.service.SkyCastService
import data.remote.service.SkyCastServiceImpl
import data.repository.SkyCastRepositoryImpl
import domain.mapper.DomainForecastDayMapper
import domain.mapper.DomainForecastHourMapper
import domain.mapper.DomainSearchItemMapper
import domain.mapper.DomainWeatherDetailsMapper
import domain.repository.SkyCastRepository
import domain.use_cases.GetCitySearchResultUseCase
import domain.use_cases.GetForecastDayUseCase
import domain.use_cases.GetForecastHourUseCase
import domain.use_cases.GetWeatherDetailsUseCase
import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.module
import presentation.home_screen.view_model.HomeViewModel
import presentation.home_screen.view_model.mapper.ForecastDayWeatherUIMapper
import presentation.home_screen.view_model.mapper.ForecastHourUIMapper
import presentation.home_screen.view_model.mapper.SearchUiMapper
import presentation.home_screen.view_model.mapper.WeatherDetailsUiMapper

const val BASE_URL = "http://api.weatherapi.com/v1"
val module = module {
    single {
        HttpClient(Java) {
            install(ContentNegotiation) {
                gson()
            }
            install(Logging) {
                level = LogLevel.ALL
            }
            defaultRequest {
                url(BASE_URL)
            }
        }
    }
    single<SkyCastService> { SkyCastServiceImpl(get()) }
    single<SkyCastRepository> {
        SkyCastRepositoryImpl(
            skyCastService = get(),
            domainWeatherDetailsMapper = get(),
            domainSearchItemMapper = get(),
            domainForecastDayMapper = get(),
            domainForecastHourMapper = get()
        )
    }

    single { DomainWeatherDetailsMapper() }
    single { DomainForecastHourMapper() }
    single { DomainForecastDayMapper() }
    single { DomainSearchItemMapper() }

    single { GetWeatherDetailsUseCase(get()) }
    single { GetCitySearchResultUseCase(get()) }
    single { GetForecastDayUseCase(get()) }
    single { GetForecastHourUseCase(get()) }

    single { HomeViewModel(
        weatherDetailsUiMapper = get(),
        searchUiMapper = get(),
        forecastDayWeatherUIMapper= get(),
        forecastHourUIMapper = get(),
        getWeatherDetailsUseCase=get(),
        getCitySearchResultUseCase=get(),
        getForecastDayUseCase=get(),
        getForecastHourUseCase=get()
    )
    }

    single { WeatherDetailsUiMapper() }
    single { SearchUiMapper() }
    single { ForecastDayWeatherUIMapper()}
    single { ForecastHourUIMapper() }
    single { GetWeatherDetailsUseCase(get()) }
    single { GetCitySearchResultUseCase (get())}
    single { GetForecastDayUseCase (get())}
    single { GetForecastHourUseCase (get())}
}

fun initKoin(): Koin {
    return startKoin {
        modules(modules = module)
    }.koin
}