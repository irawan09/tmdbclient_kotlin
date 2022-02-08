package irawan.electroshock.tmdbclient.data.repository.tvshow.datasource

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShow:List<TvShow>)
}