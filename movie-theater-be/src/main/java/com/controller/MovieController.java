package com.controller;

import com.model.dto.TopFiveMovieDTO;
import com.model.entity.Movie;
import com.model.entity.MovieImage;
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

//    @GetMapping(value = "/all-movie")
//    public ResponseEntity<?> getMovieShowing(){
//        HashMap<String, Object> hmap = new HashMap<String, Object>();
//
//        List<Movie> movieShowings = movieService.findAllMovieShowing(today);
//        List<Movie> movieComings = movieService.findAllMovieComingSoon(today);
//        List<Movie> movieTopFives = movieService.listTopFiveMovie();
//
//        hmap.put("movieShowings", movieShowings);
//        hmap.put("movieComings", movieComings);
//        hmap.put("movieTopFives", movieTopFives);
//        if (movieShowings.isEmpty() || movieComings.isEmpty() || movieTopFives.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(hmap, HttpStatus.OK);
//        }
//    }

    //    TuHC - danh sach phim dang chieu
    @GetMapping(value = "/movie-showing")
    public ResponseEntity<List<Movie>> getMovieShowings() {
        List<Movie> movieShowings = movieService.findAllMovieShowing(today);
        if (movieShowings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movieShowings, HttpStatus.OK);
        }
    }

    //    TuHC - phim sap chieu
    @GetMapping(value = "/movie-coming")
    public ResponseEntity<List<Movie>> getMovieComingSoon() {
        List<Movie> movieComingSoons = movieService.findAllMovieComingSoon(today);
        if (movieComingSoons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movieComingSoons, HttpStatus.OK);
        }
    }

    //    TuHC - phim top 5
    @GetMapping(value = "/movie-top5")
    public ResponseEntity<List<Movie>> getMovieTopFive() {
        List<Movie> movieTopFives = movieService.listTopFiveMovie();
        if (movieTopFives.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movieTopFives, HttpStatus.OK);
        }
    }

    //    TuHC - chi tiet phim
    @GetMapping(value = "/detail-movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id) {
        Movie movie = movieService.findMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //    TuHC - tim kiem phim
    @GetMapping(value = "/search-movie")
    public ResponseEntity<List<Movie>> searchMovie(@RequestParam("keyword") String keyword) {
        List<Movie> movies = movieService.searchMovie(keyword, today);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }

}
