package irawan.electroshock.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.domain.usecase.GetTvShowsUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShow() = liveData{
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList:List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }

    override fun onCleared() {
        super.onCleared()
    }
}