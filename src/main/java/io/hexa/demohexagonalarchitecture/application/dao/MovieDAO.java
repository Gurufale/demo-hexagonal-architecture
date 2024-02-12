package io.hexa.demohexagonalarchitecture.application.dao;

import io.hexa.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.hexa.demohexagonalarchitecture.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(NewMovieDto movieDto);
    void updateMovie(Movie newMovie);
    void deleteMovie(Movie oldMovie);
}
