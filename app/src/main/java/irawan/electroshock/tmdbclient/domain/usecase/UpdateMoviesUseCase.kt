package irawan.electroshock.tmdbclient.domain.usecase

import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute(): List<Movie>? = repository.updateMovies()
}