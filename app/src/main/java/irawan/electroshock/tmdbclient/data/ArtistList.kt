package irawan.electroshock.tmdbclient.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    @Expose
    val artists: List<Artist>
)
