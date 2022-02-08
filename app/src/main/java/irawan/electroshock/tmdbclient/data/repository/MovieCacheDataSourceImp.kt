package irawan.electroshock.tmdbclient.data.repository

import irawan.electroshock.tmdbclient.data.model.movie.Movie

class MovieCacheDataSourceImp: MovieCacheDataSource {
    override suspend fun getMovieFromCache(): List<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        TODO("Not yet implemented")
    }
}