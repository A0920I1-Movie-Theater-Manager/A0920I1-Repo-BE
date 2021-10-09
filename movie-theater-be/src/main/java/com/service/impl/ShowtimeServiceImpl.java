package com.service.impl;

import com.model.entity.Showtime;
import com.repository.ShowtimeRepository;
import com.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Autowired
    ShowtimeRepository showtimeRepository;

    //HueHV
    @Override
    public List<Showtime> listShowTimes() {
        return showtimeRepository.listShowTime();
    }

    @Override
    public Showtime getIdByShowDayAndShowTime(LocalTime show_time,  long price_id) {
        return showtimeRepository.getIdByShowDayAndShowTime(show_time, price_id);
    }

    //HueHV
    @Override
    public void joinTableMovieAndShowtime(long movie_id, long showtime_id) {
        showtimeRepository.joinTableMovieAndShowtime(movie_id, showtime_id);
    }

    //HueHV
    @Override
    public void addShowTimes(LocalTime showTime, long price_id) {
        showtimeRepository.addShowTime(showTime, price_id);
    }
}
