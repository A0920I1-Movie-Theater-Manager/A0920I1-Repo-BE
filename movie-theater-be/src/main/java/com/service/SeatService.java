package com.service;

import com.model.dto.SeatDTO;
import com.model.entity.Seat;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatService {
//    TuHC
    List<Seat> findAllSeatByMovieAndShowtime(long movieId, long showtimeId);
    SeatDTO findSeatBySeatNameAndShowtime(String seatName, long showtimeId, long movieId);
}
