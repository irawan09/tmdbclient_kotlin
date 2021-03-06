package irawan.electroshock.tmdbclient.domain.repository

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}