package irawan.electroshock.tmdbclient.data.model

import com.google.gson.annotations.SerializedName

data class TvShow(

    @SerializedName("first_air_date")
    val fistAirDate: String?,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val posterPath: String?
)
