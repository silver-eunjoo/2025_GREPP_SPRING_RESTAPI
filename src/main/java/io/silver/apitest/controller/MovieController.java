package io.silver.apitest.controller;


import io.silver.apitest.dto.SaveRequest;
import io.silver.apitest.dto.UpdateRequest;
import io.silver.apitest.entity.Movie;
import io.silver.apitest.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping("/{movieId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Movie> findById(@PathVariable Long movieId) {
        Movie findMovie = movieRepository.getById(movieId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(findMovie);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> save(@RequestBody SaveRequest saveRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movieRepository.save(Movie.of(saveRequest)).getId());
    }


    @PatchMapping("/{movieId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Movie> update(@PathVariable Long movieId, @RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(movieRepository.update(movieId, updateRequest));
    }

    @DeleteMapping("/{movieId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long movieId) {
        movieRepository.remove(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
