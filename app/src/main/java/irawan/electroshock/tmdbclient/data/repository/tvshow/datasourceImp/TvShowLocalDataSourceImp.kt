package irawan.electroshock.tmdbclient.data.repository.tvshow.datasourceImp

import irawan.electroshock.tmdbclient.data.db.TvShowDao
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvShowLocalDataSourceImpl(private val tvDao:TvShowDao):
    TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteAllTvShows()
        }
    }
}