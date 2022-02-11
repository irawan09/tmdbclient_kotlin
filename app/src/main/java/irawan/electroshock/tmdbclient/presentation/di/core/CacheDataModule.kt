package irawan.electroshock.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp.ArtistCacheDataSourceImp
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp.MovieCacheDataSourceImp
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp.TvShowCacheDataSourceImp
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImp()
    }
}