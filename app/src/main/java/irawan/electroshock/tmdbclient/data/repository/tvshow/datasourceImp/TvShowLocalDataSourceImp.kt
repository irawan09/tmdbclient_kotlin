package irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp

import irawan.electroshock.tmdbclient.data.db.TvShowDao
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImp(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun geTvShowFromDB(): List<TvShow> = tvShowDao.getAllTvShows()

    override suspend fun updateTvShowFromDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.insertTvShow(tvShow)
        }
    }

    override suspend fun clearTvShow() {
        CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.deleteAllTvShows()
        }
    }
}