package app.di

import data.remote.service.SkyCastService
import domain.repository.SkyCastRepository
import domain.use_cases.GetSkyCastUseCase
import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import presentation.view_model.SkyCastViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */

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
    singleOf(::SkyCastRepositoryImpl) { bind<SkyCastRepository>() }

    singleOf(::SkyCastServiceImpl) { bind<SkyCastService>() }

    single { GetSkyCastUseCase(get()) }

    single { SkyCastViewModel() }

}

fun initKoin(): Koin {
    return startKoin {
        modules(modules = module)
    }.koin
}