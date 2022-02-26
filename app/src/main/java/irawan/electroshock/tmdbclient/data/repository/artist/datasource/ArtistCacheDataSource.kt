package irawan.electroshock.tmdbclient.data.repository.artist.datasource

import irawan.electroshock.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)

}