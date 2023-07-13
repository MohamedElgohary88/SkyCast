package domain

import data.remote.dto.current.Current
import data.remote.dto.current.CurrentX
import data.remote.dto.search.SearchItem

interface SkyCastRepository {
    suspend fun getWeather(): Current
    suspend fun getCity(name:String): SearchItem
}