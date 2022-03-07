package irawan.electroshock.tmdbclient.presentation.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import irawan.electroshock.tmdbclient.R
import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.databinding.ActivityMovieBinding
import irawan.electroshock.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding:ActivityMovieBinding
    private lateinit var adapter:MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel=ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)

        initRecyclerView()


    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter =  MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovie()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovie(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response:LiveData<List<Movie>?> = movieViewModel.getMovies()
        response.observe(this,{
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE

            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Update data", Toast.LENGTH_LONG).show()
            }
        })
    }
}