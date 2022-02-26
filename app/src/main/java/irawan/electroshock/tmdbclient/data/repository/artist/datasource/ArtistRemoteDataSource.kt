package irawan.electroshock.tmdbclient.data.repository.artist.datasource

import irawan.electroshock.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}