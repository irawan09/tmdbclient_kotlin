package irawan.electroshock.tmdbclient.di

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.db.ArtistDao
import irawan.electroshock.tmdbclient.data.db.MovieDao
import irawan.electroshock.tmdbclient.data.db.TvShowDao
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp.ArtistLocalDataSourceImp
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp.MovieLocalDataSourceImp
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp.TvShowLocalDataSourceImp
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImp(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImp(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImp(tvShowDao)
    }
}