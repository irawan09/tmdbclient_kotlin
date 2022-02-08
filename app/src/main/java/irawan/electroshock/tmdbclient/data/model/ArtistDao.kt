package irawan.electroshock.tmdbclient.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import irawan.electroshock.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Query("SELECT * FROM popular_artists")
    suspend fun getALlArtists(Artist: List<Artist>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtist(Artist: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()
}