package irawan.electroshock.tmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import irawan.electroshock.tmdbclient.R
import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.databinding.ActivityMovieBinding
import irawan.electroshock.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    private  lateinit var movieViewModel: MovieViewModel
    private lateinit var binding : ActivityMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory)
            .get(MovieViewModel::class.java)

        val responseLiveData:LiveData<List<Movie>?> = movieViewModel.getMovies()
        responseLiveData.observe(this, {
            Log.i("MyTAG", it.toString())
        })
    }
}