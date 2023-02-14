package com.example.MovieInfoService.resources;

import com.example.MovieInfoService.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/movies")
public class MovieResources {
    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId) {
        return new Movie("Aletta Battle Angel", "4");
    }

}
