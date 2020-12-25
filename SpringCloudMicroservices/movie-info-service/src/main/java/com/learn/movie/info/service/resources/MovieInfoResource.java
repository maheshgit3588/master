package com.learn.movie.info.service.resources;

import com.learn.movie.info.service.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MovieInfoResource {

    @RequestMapping(path = "/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Movie " + movieId);
    }
}
