package irawan.electroshock.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.db.ArtistDao
import irawan.electroshock.tmdbclient.data.db.MovieDao
import irawan.electroshock.tmdbclient.data.db.TMDBDatabase
import irawan.electroshock.tmdbclient.data.db.TvShowDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "Webclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()
    }
}