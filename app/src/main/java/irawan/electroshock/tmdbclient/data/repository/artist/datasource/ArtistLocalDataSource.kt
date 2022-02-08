package irawan.electroshock.tmdbclient.data.repository.artist.datasource

import irawan.electroshock.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB(): List<Artist>
    suspend fun updateArtistToDB(artist:List<Artist>)
    suspend fun clearArtist()
}