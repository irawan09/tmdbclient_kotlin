package irawan.electroshock.tmdbclient.data.repository.movie.datasource

import irawan.electroshock.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}