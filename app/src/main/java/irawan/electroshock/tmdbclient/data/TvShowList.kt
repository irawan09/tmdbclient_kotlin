package irawan.electroshock.tmdbclient.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    @Expose
    val results: List<TvShow>
)
