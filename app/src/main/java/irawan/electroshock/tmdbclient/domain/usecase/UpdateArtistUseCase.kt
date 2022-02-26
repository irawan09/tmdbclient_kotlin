package irawan.electroshock.tmdbclient.domain.usecase

import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository
import javax.inject.Inject

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}