package com.controller;

import com.model.entity.Movie;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "api/movie")
@CrossOrigin("http://localhost:4200")
public class MovieController {
    private LocalDate today = LocalDate.now();

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/all-movie")
    public ResponseEntity<?> getMovieShowing(){
        HashMap<String, Object> hmap = new HashMap<String, Object>();

        List<Movie> movieShowings = movieService.findAllMovieShowing(today);
        List<Movie> movieComings = movieService.findAllMovieComingSoon(today);

        hmap.put("movieShowings", movieShowings);
        hmap.put("movieComings", movieComings);
        if (movieShowings.isEmpty() || movieComings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(hmap, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id){
        Movie movie = movieService.findMovieById(id);
        if(movie != null){
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
