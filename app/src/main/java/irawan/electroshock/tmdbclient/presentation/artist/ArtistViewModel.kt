package irawan.electroshock.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.domain.usecase.GetArtistUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtist() = liveData {
        val artistList:List<Artist>? = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList:List<Artist>? = updateArtistUseCase.execute()
        emit(artistList)
    }

    override fun onCleared() {
        super.onCleared()
    }
}