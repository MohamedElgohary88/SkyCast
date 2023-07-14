package app.util

import app.di.BASE_URL

object HttpRoutes {

    private const val API_KEY = "3e8ed63289ad4d45a2b181349230704"

    fun getCurrentWeather(city: String): String {
        return "$BASE_URL/current.json?key=$API_KEY&q=$city"
    }

    fun searchCity(city: String): String {
        return "$BASE_URL/search.json?key=$API_KEY&q=$city"
    }

    fun getForecastDays(city: String): String {
        return "$BASE_URL/forecast.json?key=$API_KEY&q=$city&days=7"
    }

    fun getForecastHours(city: String): String {
        return "$BASE_URL/forecast.json?key=$API_KEY&q=$city"
    }
}
