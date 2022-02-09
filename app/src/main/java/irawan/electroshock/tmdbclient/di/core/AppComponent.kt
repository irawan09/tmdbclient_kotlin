package irawan.electroshock.tmdbclient.di.core

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    Retrofit::class,
    UseCaseModule::class
])
interface AppComponent {
}