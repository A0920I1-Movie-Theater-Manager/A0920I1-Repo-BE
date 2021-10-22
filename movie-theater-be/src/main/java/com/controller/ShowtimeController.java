package com.controller;

import com.model.entity.Showtime;
import com.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/showtime")
@CrossOrigin("http://localhost:4200")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    //    TuHC - lay danh sach suat chieu theo phim
    @GetMapping(value = "/get-showtime/{id}")
    public ResponseEntity<List<Showtime>> getShowtimeByMovieId(@PathVariable("id") long id) {
        List<Showtime> showtimes = showtimeService.findShowtimeByMovieId(id);
        if (showtimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(showtimes, HttpStatus.OK);
        }
    }
}
