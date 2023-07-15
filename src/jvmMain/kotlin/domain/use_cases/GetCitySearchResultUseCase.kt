package domain.use_cases

import domain.entities.search.SearchItemEntity
import domain.repository.SkyCastRepository

class GetCitySearchResultUseCase(private val skyCastRepository: SkyCastRepository) {
    suspend operator fun invoke(cityName: String): List<SearchItemEntity> {
        return skyCastRepository.getCitySearchResult(cityName)
    }
}