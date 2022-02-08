package irawan.electroshock.tmdbclient.data.repository.artist.datasource

import irawan.electroshock.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtisRemoteDataSource {

    suspend fun getAllArtist(): Response<ArtistList>
}