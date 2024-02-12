package io.hexa.demohexagonalarchitecture.adapters.out.postgressJDBC.repositories;

import io.hexa.demohexagonalarchitecture.adapters.out.postgressJDBC.entities.MovieEntity;
import io.hexa.demohexagonalarchitecture.domain.Movie;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity,Long> {

    @Query("select * from movies where title =:title")
    Optional<Movie> findMovieByTitle(@Param("title") String title);

    @Query("SELECT id, title, description, releaseDate, directorName, version FROM movies")
    List<MovieEntity> findAll();

     @Modifying
    @Query("INSERT INTO movies (title, description, releaseDate, directorName, version) " +
            "VALUES (:#{#movieEntity.title}, :#{#movieEntity.description}, :#{#movieEntity.releaseDate}, " +
            ":#{#movieEntity.directorName}, :#{#movieEntity.version})")
    MovieEntity save(@Param("movieEntity") MovieEntity movieEntity);

//    MovieEntity save(MovieEntity movieEntity);
}
