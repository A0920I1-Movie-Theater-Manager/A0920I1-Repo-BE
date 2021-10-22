package com.service.impl;

import com.model.dto.ShowTimeDTO;
import com.repository.ShowtimeRepository;
import com.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Autowired
    ShowtimeRepository showtimeRepository;
    @Override
    public Page<ShowTimeDTO> getAllShowTime(Pageable pageable) {
        return showtimeRepository.getAllShowTime(pageable);
    }

    @Override
    public Page<ShowTimeDTO> searchByName(String name, Pageable pageable) {
        return showtimeRepository.searchByName(name, pageable);
    }
}
