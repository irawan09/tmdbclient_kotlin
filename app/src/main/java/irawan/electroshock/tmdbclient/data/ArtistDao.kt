package irawan.electroshock.tmdbclient.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow

@Dao
interface ArtistDao {

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getAllTvShows(tvShows : List<TvShow>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertTVShow(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()
}