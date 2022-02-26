package irawan.electroshock.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import irawan.electroshock.tmdbclient.domain.usecase.GetArtistsUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(
            getArtistsUseCase,
            updateArtistsUseCase
        ) as T
    }
}