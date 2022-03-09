package irawan.electroshock.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtistDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao:ArtistDao
    private lateinit var database:TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        dao = database.artistDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveArtistTest():Unit = runBlocking {
        val artist = listOf(
            Artist(1,"Name1", 1.0, "ProfilePath1"),
            Artist(2,"Name2", 2.0, "ProfilePath2"),
            Artist(3,"Name3", 3.0, "ProfilePath3"),
            Artist(4,"Name4", 4.0, "ProfilePath4"),
            Artist(5,"Name5", 5.0, "ProfilePath5"),
        )

        dao.saveArtists(artist)

        val allArtist:List<Artist> = dao.getArtists()
        Truth.assertThat(allArtist).isEqualTo(artist)
    }

    @Test
    fun deleteArtistTest():Unit = runBlocking {
        val artist = listOf(
            Artist(1,"Name1", 1.0, "ProfilePath1"),
            Artist(2,"Name2", 2.0, "ProfilePath2"),
            Artist(3,"Name3", 3.0, "ProfilePath3"),
            Artist(4,"Name4", 4.0, "ProfilePath4"),
            Artist(5,"Name5", 5.0, "ProfilePath5"),
        )

        dao.saveArtists(artist)
        dao.deleteAllArtists()
        val artistResults = dao.getArtists()
        Truth.assertThat(artistResults).isEmpty()
    }
}