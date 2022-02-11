package irawan.electroshock.tmdbclient.presentation.di.core

import dagger.Component
import irawan.electroshock.tmdbclient.presentation.di.artist.ArtistSubComponent
import irawan.electroshock.tmdbclient.presentation.di.movie.MovieSubComponent
import irawan.electroshock.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    RetrofitModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
}