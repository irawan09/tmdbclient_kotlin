package irawan.electroshock.tmdbclient.domain.repository

import irawan.electroshock.tmdbclient.data.model.movie.Movie


interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}