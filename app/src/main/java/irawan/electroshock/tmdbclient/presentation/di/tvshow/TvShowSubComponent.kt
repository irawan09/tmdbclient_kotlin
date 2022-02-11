package irawan.electroshock.tmdbclient.presentation.di.tvshow

import dagger.Subcomponent
import irawan.electroshock.tmdbclient.presentation.tvshow.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}