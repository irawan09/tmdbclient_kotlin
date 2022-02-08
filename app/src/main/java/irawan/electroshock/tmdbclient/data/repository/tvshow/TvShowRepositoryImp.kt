package irawan.electroshock.tmdbclient.data.repository.tvshow

import android.util.Log
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShowList
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import irawan.electroshock.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

class TvShowRepositoryImp(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows: List<TvShow> = getTvShowFromAPI()
        tvShowLocalDataSource.clearTvShow()
        tvShowLocalDataSource.updateTvShowFromDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowFromAPI(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getAllTvShow()
            val body : TvShowList? = response.body()
            if (body != null){
                tvShowList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.geTvShowFromDB()
        }catch (exception:Exception){
            Log.i("MyTAG", exception.message.toString())
        }
        if(tvShowList != null){
            return tvShowList
        }else {
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.updateTvShowFromDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (exception:Exception){
         Log.i("MyTAG", exception.message.toString())
        }
        if(tvShowList != null){
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}