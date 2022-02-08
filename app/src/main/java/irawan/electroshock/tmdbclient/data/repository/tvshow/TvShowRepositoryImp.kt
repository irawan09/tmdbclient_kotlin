package irawan.electroshock.tmdbclient.data.repository.tvshow

import android.util.Log
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShowList
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImp(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    suspend fun getTvShowFromAPI(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {

        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }


        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {

        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {

        }catch (exception:Exception){
         Log.i("MyTAG", exception.message.toString())
        }
        return tvShowList
    }
}