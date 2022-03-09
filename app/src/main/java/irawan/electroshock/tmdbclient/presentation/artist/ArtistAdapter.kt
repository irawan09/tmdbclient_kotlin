package irawan.electroshock.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import irawan.electroshock.tmdbclient.R
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.databinding.ListItemBinding

class ArtistAdapter:RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artist: List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
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
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class MyViewHolder(val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

    fun bind(artist:Artist){
        itemBinding.titleTextView.text = artist.name
        itemBinding.descriptionTextView.text = artist.popularity.toString()
        val posterURL: String = "https://image.tmdb.org/t/p/w500"+artist.profilePath

        Glide.with(itemBinding.imageView.context)
            .load(posterURL)
            .into(itemBinding.imageView)
    }
}