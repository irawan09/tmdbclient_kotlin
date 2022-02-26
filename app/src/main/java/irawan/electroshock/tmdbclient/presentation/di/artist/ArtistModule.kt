package irawan.electroshock.tmdbclient.presentation.di.artist

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.domain.usecase.GetArtistsUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateArtistsUseCase
import irawan.electroshock.tmdbclient.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}