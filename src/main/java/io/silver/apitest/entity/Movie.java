package io.silver.apitest.entity;

import io.silver.apitest.dto.SaveRequest;
import io.silver.apitest.dto.UpdateRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long id;
    private String title;
    private String actor;
    private String contents;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();


    public Movie update(UpdateRequest updateRequest) {
        this.title = updateRequest.getTitle();
        this.actor = updateRequest.getActor();
        this.updatedAt = LocalDateTime.now();

        return this;
    }

    public static Movie of(SaveRequest request) {
        Movie movie = new Movie();
        movie.title = request.getTitle();
        movie.actor = request.getActor();
        movie.contents = request.getContents();

        return movie;
    }

}
