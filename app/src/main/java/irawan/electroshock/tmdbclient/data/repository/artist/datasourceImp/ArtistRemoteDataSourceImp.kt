package irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp

import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.model.artist.ArtistList
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtisRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey: String):ArtisRemoteDataSource {
    override suspend fun getAllArtist(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}