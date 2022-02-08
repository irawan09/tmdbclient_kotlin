package irawan.electroshock.tmdbclient.data.repository.artist

import android.util.Log
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.data.model.artist.ArtistList
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import irawan.electroshock.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImp(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {
    override suspend fun getAllArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists: List<Artist> = getArtistFromAPI()
        artistLocalDataSource.clearArtist()
        artistLocalDataSource.updateArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getAllArtist()
            val body : ArtistList? = response.body()
            if(body != null){
                artistList = body.artists
            }
        }catch (exception: Exception){
         Log.i("MyTAG", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        if (artistList != null){
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.updateArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromDataCache()
        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        if (artistList!=null){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}