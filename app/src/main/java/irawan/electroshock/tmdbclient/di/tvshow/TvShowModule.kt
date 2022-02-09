package irawan.electroshock.tmdbclient.di.tvshow

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.domain.usecase.GetTvShowsUseCase
import irawan.electroshock.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import irawan.electroshock.tmdbclient.presentation.tvshow.TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}