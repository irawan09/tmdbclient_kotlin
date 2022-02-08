package irawan.electroshock.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getAllTvShows():List<TvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()
}