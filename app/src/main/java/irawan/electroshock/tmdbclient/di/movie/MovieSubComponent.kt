package irawan.electroshock.tmdbclient.di.movie

import dagger.Subcomponent
import irawan.electroshock.tmdbclient.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}