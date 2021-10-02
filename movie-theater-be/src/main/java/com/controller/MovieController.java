package com.controller;

import com.model.entity.Genre;
import com.service.GenreService;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/movie")
@CrossOrigin("http://localhost:4200")
public class MovieController {
    @Autowired
    private GenreService genreService;
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/getAllMovie")
    public ResponseEntity<List<Genre>> getAllGenre(){
        return ResponseEntity.ok(genreService.findAllGenre());
    }
}
