package data.remote.service

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

object LocationManager {
    suspend fun getLocation(): Location {
        return withContext(Dispatchers.IO) {
            val url = URL("https://ipinfo.io/json")
            val json = url.readText()
            val gson = Gson()
            val data = gson.fromJson(json, Location::class.java)
            val city = data.city
            val location = data.loc
            Location(city = city, loc = location)
        }
    }
}

data class Location(
    val loc: String,
    val city: String
)
