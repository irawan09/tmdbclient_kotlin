package irawan.electroshock.tmdbclient.data.repository.tvshow.datasource

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)

}