package irawan.electroshock.tmdbclient.presentation.artist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.databinding.ListItemBinding

class ArtistAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class MyViewHolder(val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

    fun bind(artist:Artist){
        itemBinding.titleTextView.text = artist.name
//        itemBinding.descriptionTextView.text = artist.
        val posterURL:String? = "https://image.tmdb.org/t/p/w500"+artist.profilePath
    }
}