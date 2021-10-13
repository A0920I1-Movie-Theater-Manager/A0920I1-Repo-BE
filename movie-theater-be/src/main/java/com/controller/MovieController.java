package com.controller;

import com.model.entity.Comment;
import com.model.entity.Movie;
import com.service.CommentService;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/movie")
@CrossOrigin("http://localhost:4200")
public class MovieController {
    private LocalDate today = LocalDate.now();

    @Autowired
    private MovieService movieService;
    @Autowired
    private CommentService commentService;

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

//    TuHC - lay comment cho 1 bo phim
    @GetMapping(value = "/get-comment/{id}")
    public ResponseEntity<List<Comment>> getAllCommentByMovieId(@PathVariable("id") long id){
        List<Comment> comments = commentService.findAllCommentByMovieId(id);

        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/add-comment")
    public ResponseEntity<Comment> addNewComment(@RequestBody Comment comment){
        commentService.addNewComment(comment.getContent(), comment.getMovie());
        return new ResponseEntity(HttpStatus.OK);
    }
}
