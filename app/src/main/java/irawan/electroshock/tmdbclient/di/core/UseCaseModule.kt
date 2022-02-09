package irawan.electroshock.tmdbclient.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository
import irawan.electroshock.tmdbclient.domain.repository.MovieRepository
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository
import irawan.electroshock.tmdbclient.domain.usecase.*
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}