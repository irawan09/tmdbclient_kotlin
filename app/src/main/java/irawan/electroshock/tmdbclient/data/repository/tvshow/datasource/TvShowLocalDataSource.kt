package irawan.electroshock.tmdbclient.data.repository.tvshow.datasource

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun geTvShowFromDB(): List<TvShow>
    suspend fun updateTvShowFromDB(tvShow: List<TvShow>)
    suspend fun clearTvShow()
}