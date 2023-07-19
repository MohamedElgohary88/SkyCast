package presentation.home_screen.view_model.mapper

import domain.entities.search.SearchItemEntity
import domain.mapper.Mapper
import presentation.home_screen.view_model.SearchItemUIState

class SearchUiMapper:Mapper<SearchItemEntity, SearchItemUIState> {
    override fun map(input: SearchItemEntity): SearchItemUIState {
        return SearchItemUIState(
            cityName=input.name
        )
    }
}