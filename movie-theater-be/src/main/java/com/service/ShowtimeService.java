package com.service;

import com.model.dto.ShowTimeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ShowtimeService {
    Page<ShowTimeDTO> getAllShowTime(Pageable pageable);
    Page<ShowTimeDTO> searchByName(String name, Pageable pageable);
}
