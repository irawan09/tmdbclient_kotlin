package irawan.electroshock.tmdbclient.data.repository.tvshow.datasource

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}