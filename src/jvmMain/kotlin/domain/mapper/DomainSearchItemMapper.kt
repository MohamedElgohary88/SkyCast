package domain.mapper

import data.remote.dto.search.SearchItemRemoteDto
import domain.entities.search.SearchItemEntity

/**
 * Created by Mohamed Elgohary on 7/15/2023.
 */
class DomainSearchItemMapper : Mapper<SearchItemRemoteDto, SearchItemEntity> {
    override fun map(input: SearchItemRemoteDto): SearchItemEntity {
        return SearchItemEntity(
            country = input.country,
            name = input.name,
            region = input.region
        )
    }

}