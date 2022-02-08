package irawan.electroshock.tmdbclient.data.repository

import irawan.electroshock.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImp : MovieRemoteDataSource {
    override suspend fun getALlMovies(): Response<MovieList> {
        TODO("Not yet implemented")
    }
}