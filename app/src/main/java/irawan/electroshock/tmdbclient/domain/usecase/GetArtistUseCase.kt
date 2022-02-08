package irawan.electroshock.tmdbclient.domain.usecase

import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val repository: ArtistRepository) {

    suspend fun execute():List<Artist>? = repository.getAllArtists()
}