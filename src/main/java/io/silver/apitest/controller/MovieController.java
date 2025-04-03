package io.silver.apitest.controller;


import io.silver.apitest.dto.SaveRequest;
import io.silver.apitest.dto.UpdateRequest;
import io.silver.apitest.entity.Movie;
import io.silver.apitest.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping("/{movieId}")
    public Movie findById(@PathVariable Long movieId) {
        Movie findMovie = movieRepository.getById(movieId);

        return findMovie;
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PatchMapping("/{movieId}")
    public Movie update(@PathVariable Long movieId, @RequestBody UpdateRequest updateRequest) {
        Movie updatedMovie = movieRepository.update(movieId, updateRequest);

        return updatedMovie;
    }

    @DeleteMapping("/{movieId}")
    public void delete(@PathVariable Long movieId) {
        movieRepository.remove(movieId);
    }
}
