package com.service;

import com.model.entity.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShowtimeService {
    //HueHV
    List<Showtime> listShowTimes();

    //HueHV
    Showtime getIdByShowDayAndShowTime(LocalDate show_date, LocalTime show_time);

    //HueHV
    void joinTableMovieAndShowtime(long movie_id, long showtime_id);

    //HueHV
    void addShowTimes(LocalTime showTime, LocalDate showDay, long price_id);
}
