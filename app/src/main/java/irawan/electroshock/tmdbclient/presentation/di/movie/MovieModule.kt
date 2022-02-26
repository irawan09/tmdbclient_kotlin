package irawan.electroshock.tmdbclient.presentation.di.movie

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.domain.usecase.GetMoviesUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateMoviesUsecase
import irawan.electroshock.tmdbclient.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}