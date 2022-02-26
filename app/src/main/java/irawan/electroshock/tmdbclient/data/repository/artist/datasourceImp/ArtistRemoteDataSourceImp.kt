package irawan.electroshock.tmdbclient.data.repository.artist.datasourceImp

import irawan.electroshock.tmdbclient.data.api.TMDBService
import irawan.electroshock.tmdbclient.data.model.artist.ArtistList
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}