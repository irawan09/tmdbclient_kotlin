package irawan.electroshock.tmdbclient.data.repository.movie

import android.util.Log
import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.data.model.movie.MovieList
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import irawan.electroshock.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies:List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearMovie()
        movieLocalDataSource.updateMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try{
            val response:Response<MovieList> = movieRemoteDataSource.getALlMovies()
            val body : MovieList? = response.body()
            Log.i("MyTAG", body.toString())
            if(body!=null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        } else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.updateMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = movieCacheDataSource.getMovieFromCache()
        }catch (exception: Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        if(movieList!=null){
            return movieList
        } else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }

        return movieList
    }
}