package irawan.electroshock.tmdbclient.data.repository.movie.datasource

import irawan.electroshock.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}