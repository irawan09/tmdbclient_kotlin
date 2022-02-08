package irawan.electroshock.tmdbclient.data.repository.tvshow.datasource

import irawan.electroshock.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getAllTvShow(): Response<TvShowList>
}