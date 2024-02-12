package io.hexa.demohexagonalarchitecture.application.usecases;

import io.hexa.demohexagonalarchitecture.Infrastructure.exceptions.MovieAlreadyExistsException;
import io.hexa.demohexagonalarchitecture.Infrastructure.exceptions.MovieNotFoundException;
import io.hexa.demohexagonalarchitecture.application.dao.MovieDAO;
import io.hexa.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.hexa.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieUseCase {

    private final MovieDAO movieDAO;

    public String saveMovie(NewMovieDto newMovieDto) {
        boolean isPresent = movieDAO.findMovieByTitle(newMovieDto.title()).isPresent();
        if (isPresent) throw new MovieAlreadyExistsException("Movie already exists");

        movieDAO.saveMovie(newMovieDto);
        return "Movie saved successfully";
    }

    public List<Movie> getAllMovies() {
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) {
        boolean isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent) {
         throw new MovieNotFoundException("Movie doesn't exists");
        }

        movieDAO.updateMovie(movie);
        return "Movie updated successfully";
    }

    public Movie findByTitle(String movieTitle) {
       return  movieDAO.findMovieByTitle(movieTitle).orElseThrow(()->new MovieNotFoundException("Movie doesn't exists"));
    }
}
