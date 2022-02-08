package irawan.electroshock.tmdbclient.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val poster_path: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("title")
    val title: String?
)
