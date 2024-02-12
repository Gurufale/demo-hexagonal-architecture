package io.hexa.demohexagonalarchitecture.adapters.in.web;

import io.hexa.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.hexa.demohexagonalarchitecture.application.usecases.MovieUseCase;
import io.hexa.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieUseCase movieUseCase;

    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        return  ResponseEntity.ok(movieUseCase.findByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody NewMovieDto newMovieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.saveMovie(newMovieDto));
    }

    @PutMapping
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.updateMovie(movie));
    }


}
