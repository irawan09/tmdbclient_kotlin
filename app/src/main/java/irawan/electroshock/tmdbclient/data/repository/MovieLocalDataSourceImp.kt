package irawan.electroshock.tmdbclient.data.repository

import irawan.electroshock.tmdbclient.data.model.movie.Movie

class MovieLocalDataSourceImp : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun updateMoviesToDB(movies: List<Movie>) {
        TODO("Not yet implemented")
    }

    override suspend fun clearMovie() {
        TODO("Not yet implemented")
    }
}