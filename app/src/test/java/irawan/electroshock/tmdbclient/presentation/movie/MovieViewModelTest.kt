package irawan.electroshock.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isEqualTo
import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.data.repository.movie.FakeMovieRepository
import irawan.electroshock.tmdbclient.domain.usecase.GetMoviesUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateMoviesUsecase
import irawan.electroshock.tmdbclient.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUsecase = UpdateMoviesUsecase(fakeMovieRepository)
        movieViewModel = MovieViewModel(getMoviesUseCase, updateMoviesUsecase)

    }

    @Test
    fun getMovies_returnCurrentList(){
        val movies = mutableListOf<Movie>()

        movies.add(
            Movie(1,
                "overview1",
                "posterPath1",
                "date1",
                "title1"
            )
        )
        movies.add(
            Movie(2,
                "overview2",
                "posterPath2",
                "date2",
                "title2"
            )
        )

        val currentList = movieViewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "path3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "path4", "date4", "title4"))

        val updatedList = movieViewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}