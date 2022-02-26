package irawan.electroshock.tmdbclient.domain.repository

import irawan.electroshock.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}