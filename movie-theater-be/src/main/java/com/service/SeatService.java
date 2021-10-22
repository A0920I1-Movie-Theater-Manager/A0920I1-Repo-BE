package com.service;

import com.model.entity.Seat;

import java.util.List;

public interface SeatService {
//    TuHC
    List<Seat> findAllSeatByMovieAndShowtime(long movieId, long showtimeId);
}
