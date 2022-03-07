package irawan.electroshock.tmdbclient.presentation.tvshow

import irawan.electroshock.tmdbclient.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import irawan.electroshock.tmdbclient.data.model.tvshow.TvShow
import irawan.electroshock.tmdbclient.databinding.ListItemBinding

class TvShowAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShow: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShow)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(val itemBinding: ListItemBinding):RecyclerView.ViewHolder(itemBinding.root){

    fun bind(tvShow: TvShow){
        itemBinding.titleTextView.text = tvShow.name
        itemBinding.descriptionTextView.text = tvShow.overview
        val posterURL:String? = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath

        Glide.with(itemBinding.imageView.context)
            .load(posterURL)
            .into(itemBinding.imageView)
    }

}