package domain.entities.current



data class CurrentWeatherEntity(
    val code: Int?,
    val icon: String?,
    val text: String?,
    val cloud: Int?,
    val temperatureCelsius: Double?,
    val feelsLikeCelsius: Double?,
    val country: String?,
    val localTime: String?,
    val name: String?,
    val region: String?,
)