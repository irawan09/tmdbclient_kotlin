package irawan.electroshock.tmdbclient.data.repository.artist

import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImp():ArtistRepository {
    override suspend fun getAllArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }
}