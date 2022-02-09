package irawan.electroshock.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.domain.usecase.GetMoviesUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase : UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList: List<Movie>? = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData{
        val movieList:List<Movie>? = updateMovieUseCase.execute()
        emit(movieList)
    }

    override fun onCleared() {
        super.onCleared()
    }

}