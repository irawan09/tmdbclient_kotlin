package irawan.electroshock.tmdbclient.data.repository.movie.datasource

import irawan.electroshock.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMovieFromCache(): List<Movie>
    suspend fun saveMovieToCache(movies:List<Movie>)
}