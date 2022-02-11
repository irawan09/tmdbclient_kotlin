package irawan.electroshock.tmdbclient.presentation.di

import irawan.electroshock.tmdbclient.presentation.di.artist.ArtistSubComponent
import irawan.electroshock.tmdbclient.presentation.di.movie.MovieSubComponent
import irawan.electroshock.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
}