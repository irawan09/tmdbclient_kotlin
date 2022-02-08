package irawan.electroshock.tmdbclient.data.repository

import irawan.electroshock.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun updateMoviesToDB(movies: List<Movie>)
    suspend fun clearMovie()
}