package irawan.electroshock.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import irawan.electroshock.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM popular_movies")
    suspend fun getAllMovies(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()
}