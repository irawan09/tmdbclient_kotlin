package irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp

import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImp: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}