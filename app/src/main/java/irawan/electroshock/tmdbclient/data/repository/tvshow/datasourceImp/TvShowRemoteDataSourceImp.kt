package irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp

import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShowList
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDatasource {
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}