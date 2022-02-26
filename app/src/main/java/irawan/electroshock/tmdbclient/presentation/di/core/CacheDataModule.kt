package irawan.electroshock.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp.ArtistCacheDataSourceImpl
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp.MovieCacheDataSourceImpl
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}