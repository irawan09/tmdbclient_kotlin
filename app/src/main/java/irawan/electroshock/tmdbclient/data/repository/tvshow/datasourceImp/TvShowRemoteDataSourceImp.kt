package irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp

import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShowList
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getAllTvShow(): Response<TvShowList> = tmdbService.getPopularTVShows(apiKey)
}