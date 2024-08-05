package org.landvibe.ass1.controller;

import lombok.RequiredArgsConstructor;
import org.landvibe.ass1.Movie;
import org.landvibe.ass1.MovieESRepository;
import org.landvibe.ass1.MovieRDBRepository;
import org.landvibe.ass1.dummy.Dummy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class controller {
    private final MovieRDBRepository movieRDBRepository;
    private final MovieESRepository movieESRepository;

    @GetMapping("/movies/rdb/{title}")
    public List<Movie> getMovieByTitle(@PathVariable("title") String title) {
        return movieRDBRepository.getMovieByTitle(title);
    }

    @GetMapping("/movies/es/{title}")
    public List<Movie> getMovieByTitleES(@PathVariable("title") String title) {
        return movieESRepository.findByTitle(title);
    }
}