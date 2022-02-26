package irawan.electroshock.tmdbclient.presentation.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import irawan.electroshock.tmdbclient.domain.usecase.GetMoviesUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        Log.i("MyTAG", movieList.toString())
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }

}