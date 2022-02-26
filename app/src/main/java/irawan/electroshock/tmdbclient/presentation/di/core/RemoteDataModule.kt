package irawan.electroshock.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp.ArtistRemoteDataSourceImpl
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp.MovieRemoteDataSourceImpl
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}