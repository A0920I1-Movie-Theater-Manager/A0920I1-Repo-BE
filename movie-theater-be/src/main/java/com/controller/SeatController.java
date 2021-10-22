package com.controller;

import com.model.dto.SeatDTO;
import com.model.entity.Seat;
import com.service.SeatService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/seat")
@CrossOrigin("http://localhost:4200")
public class SeatController {
    @Autowired
    private SeatService seatService;

//    TuHC - lay ghe theo movie va showtime
    @GetMapping(value = "/get-seat/{movieId}/{showtimeId}")
    public ResponseEntity<List<Seat>> getAllSeatByScreen(@PathVariable("movieId") long movieId,
                                                         @PathVariable("showtimeId") long showtimeId){
        List<Seat> seats = seatService.findAllSeatByMovieAndShowtime(movieId, showtimeId);
        if(seats.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(seats, HttpStatus.OK);
        }
    }
}
