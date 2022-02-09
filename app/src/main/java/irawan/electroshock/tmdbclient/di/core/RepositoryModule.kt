package irawan.electroshock.tmdbclient.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.repository.artist.ArtistRepositoryImp
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.MovieRepositoryImp
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.TvShowRepositoryImp
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository
import irawan.electroshock.tmdbclient.domain.repository.MovieRepository
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImp(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository{
        return ArtistRepositoryImp(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository{
        return TvShowRepositoryImp(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource)
    }
}