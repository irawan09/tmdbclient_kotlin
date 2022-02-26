package irawan.electroshock.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import irawan.electroshock.tmdbclient.data.repository.movie.MovieRepositoryImpl
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import irawan.electroshock.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository
import irawan.electroshock.tmdbclient.domain.repository.MovieRepository
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}