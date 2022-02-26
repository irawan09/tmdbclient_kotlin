package irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp

import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.model.movie.MovieList
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}