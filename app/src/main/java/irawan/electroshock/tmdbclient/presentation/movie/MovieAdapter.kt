package irawan.electroshock.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import irawan.electroshock.tmdbclient.R
import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.databinding.ListItemBinding

class MovieAdapter:RecyclerView.Adapter<MyViewHolder>()  {
    private val movieList = ArrayList<Movie>()

    fun setList(movie: List<Movie>){
        movieList.clear()
        movieList.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MyViewHolder(private val itemBinding: ListItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(movie:Movie){
            itemBinding.titleTextView.text = movie.title
            itemBinding.descriptionTextView.text = movie.overview
            val posterURL: String = "https://image.tmdb.org/t/p/w500"+movie.posterPath

            Glide.with(itemBinding.imageView.context)
                .load(posterURL)
                .into(itemBinding.imageView)
        }
}