package irawan.electroshock.tmdbclient.presentation.di.artist

import dagger.Subcomponent
import irawan.electroshock.tmdbclient.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }
}