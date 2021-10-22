package com.service;

import com.model.entity.Showtime;

import java.util.List;

public interface ShowtimeService {
    //    TuHC
    List<Showtime> findShowtimeByMovieId(long id);
}
