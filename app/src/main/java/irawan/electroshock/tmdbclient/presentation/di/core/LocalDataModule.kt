package irawan.electroshock.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.db.ArtistDao
import irawan.electroshock.tmdbclient.data.db.MovieDao
import irawan.electroshock.tmdbclient.data.db.TvShowDao
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp.ArtistLocalDataSourceImpl
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp.MovieLocalDataSourceImpl
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }


}