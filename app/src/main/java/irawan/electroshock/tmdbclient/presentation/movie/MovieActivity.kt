package irawan.electroshock.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import irawan.electroshock.tmdbclient.R
import irawan.electroshock.tmdbclient.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}