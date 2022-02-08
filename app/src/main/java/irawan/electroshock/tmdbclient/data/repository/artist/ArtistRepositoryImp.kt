package irawan.electroshock.tmdbclient.data.repository.artist

import android.util.Log
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImp(
    private val artistRemoteDataSource: TvShowRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {
    override suspend fun getAllArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {

        }catch (exception: Exception){
         Log.i("MyTAG", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist>{
        lateinit var artistList : List<Artist>
        try {

        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList : List<Artist>
        try {

        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }

        return artistList
    }
}