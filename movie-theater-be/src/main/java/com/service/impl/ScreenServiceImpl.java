package com.service.impl;

import com.model.entity.Movie;
import com.model.entity.Screen;
import com.repository.ScreenRepository;
import com.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Autowired
    ScreenRepository screenRepository;

    @Override
    public List<Screen> findAll() {
        return screenRepository.findAll();
    }
}
