package irawan.electroshock.tmdbclient.data.repository.tvshow

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImp(): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }
}