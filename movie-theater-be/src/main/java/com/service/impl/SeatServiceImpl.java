package com.service.impl;

import com.model.dto.SeatDTO;
import com.model.entity.Seat;
import com.repository.SeatRepository;
import com.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    //TuHC - lay ghe theo phim va gio chieu
    @Override
    public List<Seat> findAllSeatByMovieAndShowtime(long movieId, long showtimeId) {
        return seatRepository.findAllSeatByMovieAndShowtime(movieId, showtimeId);
    }

    //    TuHC - lay ghe theo ten ghe va gio chieu
    @Override
    public SeatDTO findSeatBySeatNameAndShowtime(String seatName, long showtimeId, long movieId) {
        return seatRepository.findSeatBySeatNameAndShowtime(seatName, showtimeId, movieId);
    }

}
