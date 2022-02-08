package irawan.electroshock.tmdbclient.domain.usecase

import irawan.electroshock.tmdbclient.data.model.movie.Movie
import irawan.electroshock.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}