package irawan.electroshock.tmdbclient.domain.usecase

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val repository: TvShowRepository) {

    suspend fun execute() : List<TvShow>? = repository.updateTvShows()
}