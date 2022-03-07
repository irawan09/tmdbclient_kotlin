package irawan.electroshock.tmdbclient.presentation.artist

import androidx.recyclerview.widget.RecyclerView
import irawan.electroshock.tmdbclient.data.model.artist.Artist
import irawan.electroshock.tmdbclient.databinding.ListItemBinding

class ArtistAdapter {
}

class MyViewHolder(val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

    fun bind(artist:Artist){
        itemBinding.titleTextView.text = artist.name
//        itemBinding.descriptionTextView.text = artist.
    }
}