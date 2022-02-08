package irawan.electroshock.tmdbclient.data.repository.artist.datasource

import irawan.electroshock.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistFromDataCache():List<Artist>
    suspend fun saveArtistToCache(artist:List<Artist>)
}