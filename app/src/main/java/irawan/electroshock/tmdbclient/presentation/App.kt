package irawan.electroshock.tmdbclient.presentation

import android.app.Application
import irawan.electroshock.tmdbclient.BuildConfig
import irawan.electroshock.tmdbclient.presentation.di.Injector
import irawan.electroshock.tmdbclient.presentation.di.artist.ArtistSubComponent
import irawan.electroshock.tmdbclient.presentation.di.core.*
import irawan.electroshock.tmdbclient.presentation.di.movie.MovieSubComponent
import irawan.electroshock.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App:Application(), Injector {

    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .retrofitModule(RetrofitModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

}