package com.service.impl;

import com.model.entity.Showtime;
import com.repository.ShowtimeRepository;
import com.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;

//    TuHC - lay gio chieu theo phim
    @Override
    public List<Showtime> findShowtimeByMovieId(long id) {
        return showtimeRepository.findShowtimeByMovieId(id);
    }
}
