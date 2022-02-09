package irawan.electroshock.tmdbclient.di.artist

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.domain.usecase.GetArtistUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateArtistUseCase
import irawan.electroshock.tmdbclient.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase,updateArtistUseCase)
    }
}