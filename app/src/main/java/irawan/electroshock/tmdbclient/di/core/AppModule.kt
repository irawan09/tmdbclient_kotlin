package irawan.electroshock.tmdbclient.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}