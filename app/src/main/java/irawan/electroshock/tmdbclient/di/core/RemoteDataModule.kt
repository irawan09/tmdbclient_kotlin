package irawan.electroshock.tmdbclient.di.core

import dagger.Module
import dagger.Provides
import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.db.TMDBDatabase
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp.ArtistRemoteDataSourceImp
import irawan.electroshock.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import irawan.electroshock.tmdbclient.data.repository.movie.datasourceImp.MovieRemoteDataSourceImp
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp.TvShowRemoteDataSourceImp
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideRemoteMovieDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImp(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideRemoteArtistDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImp(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideRemoteTvShowDataSource(tmdbService: TMDBService):TvShowRemoteDataSourceImp{
        return TvShowRemoteDataSourceImp(tmdbService, apiKey)
    }
}