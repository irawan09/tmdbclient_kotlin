package irawan.electroshock.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.presentation.di.artist.ArtistSubComponent
import irawan.electroshock.tmdbclient.presentation.di.movie.MovieSubComponent
import irawan.electroshock.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}