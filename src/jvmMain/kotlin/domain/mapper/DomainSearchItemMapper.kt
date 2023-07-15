package domain.mapper

import data.remote.dto.search.SearchItemRemoteDto
import domain.entities.search.SearchItemEntity

class DomainSearchItemMapper : Mapper<SearchItemRemoteDto, SearchItemEntity> {
    override fun map(input: SearchItemRemoteDto): SearchItemEntity {
        return SearchItemEntity(
            country = input.country,
            name = input.name,
            region = input.region
        )
    }

    override fun mapSingle(input: List<SearchItemRemoteDto>): List<SearchItemEntity> {
        return input.map(::map)
    }
}
