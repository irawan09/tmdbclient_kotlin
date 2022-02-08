package irawan.electroshock.tmdbclient.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    @Expose
    val  movies:List<Movie>
)
