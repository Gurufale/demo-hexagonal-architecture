package io.hexa.demohexagonalarchitecture.adapters.out.postgressJDBC;

import io.hexa.demohexagonalarchitecture.adapters.out.postgressJDBC.entities.MovieEntity;
import io.hexa.demohexagonalarchitecture.adapters.out.postgressJDBC.repositories.MoviesRepository;
import io.hexa.demohexagonalarchitecture.application.dao.MovieDAO;
import io.hexa.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.hexa.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDAO {

    private final MoviesRepository moviesRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>)moviesRepository.findAll())
                .stream().map(MovieEntity -> new Movie(MovieEntity.id(), MovieEntity.title(),
                         MovieEntity.description(),
                         MovieEntity.releaseDate(),
                         MovieEntity.directorName())).toList();
    }

    @Override
    public void saveMovie(NewMovieDto movieDto) {
         moviesRepository.save(new MovieEntity(null,
                 movieDto.title(),
                 movieDto.description(),
                 movieDto.releaseDate(),
                 movieDto.directorName(),
                 null
         ));
    }

    @Override
    public void updateMovie(Movie newMovie) {
        moviesRepository.save(new MovieEntity(newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {

    }
}
