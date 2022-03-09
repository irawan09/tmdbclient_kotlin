package irawan.electroshock.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao:TvShowDao
    private lateinit var database:TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        dao = database.tvDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveTvShowTest():Unit = runBlocking {
        val tvShow = listOf(
            TvShow(
                "AirDate1",
                1,
                "Name1",
                "Overview1",
                "Poster1"),
            TvShow(
                "AirDate2",
                2,
                "Name2",
                "Overview2",
                "Poster2"),
            TvShow(
                "AirDate3",
                3,
                "Name3",
                "Overview3",
                "Poster3"),
            TvShow(
                "AirDate4",
                4,
                "Name4",
                "Overview4",
                "Poster4"),
            TvShow(
                "AirDate5",
                5,
                "Name5",
                "Overview5",
                "Poster5")
        )

        dao.saveTvShows(tvShow)

        val allTvShows:List<TvShow> = dao.getTvShows()
        Truth.assertThat(allTvShows).isEqualTo(tvShow)
    }

    @Test
    fun deleteTvShowTest():Unit = runBlocking {
        val tvShow = listOf(
            TvShow(
                "AirDate1",
                1,
                "Name1",
                "Overview1",
                "Poster1"),
            TvShow(
                "AirDate2",
                2,
                "Name2",
                "Overview2",
                "Poster2"),
            TvShow(
                "AirDate3",
                3,
                "Name3",
                "Overview3",
                "Poster3"),
            TvShow(
                "AirDate4",
                4,
                "Name4",
                "Overview4",
                "Poster4"),
            TvShow(
                "AirDate5",
                5,
                "Name5",
                "Overview5",
                "Poster5")
        )

        dao.saveTvShows(tvShow)
        dao.deleteAllTvShows()
        val tvShowResult = dao.getTvShows()
        Truth.assertThat(tvShowResult).isEmpty()
    }
}