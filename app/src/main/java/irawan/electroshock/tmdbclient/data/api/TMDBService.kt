package irawan.electroshock.tmdbclient.data.api

import irawan.electroshock.tmdbclient.data.model.ArtistList
import retrofit2.http.Query
import irawan.electroshock.tmdbclient.data.model.MovieList
import irawan.electroshock.tmdbclient.data.model.TvShowList
import retrofit2.Response
import retrofit2.http.GET

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")apiKey:String
    ):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query("api_key")apiKey:String
    ):Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key")apiKey:String
    ):Response<ArtistList>
}