package irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp

import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.model.movie.MovieList
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey: String) : MovieRemoteDataSource {
    override suspend fun getALlMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}