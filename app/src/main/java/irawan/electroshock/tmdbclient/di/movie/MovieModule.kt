package irawan.electroshock.tmdbclient.di.movie

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.domain.usecase.GetMoviesUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateMoviesUseCase
import irawan.electroshock.tmdbclient.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}