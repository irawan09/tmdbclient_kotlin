package irawan.electroshock.tmdbclient.data.model.tvshow

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    @Expose
    val results: List<TvShow>
)
