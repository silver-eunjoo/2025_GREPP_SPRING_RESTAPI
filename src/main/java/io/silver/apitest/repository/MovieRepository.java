package io.silver.apitest.repository;

import io.silver.apitest.dto.UpdateRequest;
import io.silver.apitest.entity.Movie;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private Long sequence = 0L;
    Map<Long, Movie> movieList = new HashMap<>();

    public Movie save(Movie movie) {
        sequence ++;
        Movie newMovie = movieList.put(sequence, movie);

        return newMovie;
    }

    public Movie getById(Long id) {
        Movie findMovie = movieList.get(id);

        return findMovie;
    }

    public void remove(Long id) {
        movieList.remove(id);
    }

    public Movie update(Long id, UpdateRequest updateRequest) {
        Movie findMovie = movieList.get(id);
        Movie updatedMovie = findMovie.update(updateRequest);

        return updatedMovie;
    }

}
