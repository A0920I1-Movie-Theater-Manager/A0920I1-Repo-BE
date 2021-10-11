package com.service.impl;

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
    public List<Screen> getAllScreen() {
        return screenRepository.findAllScreen();
    }

    @Override
    public Screen findById(long id) {
        return screenRepository.findById(id).orElse(null);
    }


    @Override
    public List<Screen> searchName(String name) {
        return screenRepository.searchName(name);
    }

    @Override
    public void createScreen(String name, int totalSeat) {
        screenRepository.createScreen(name,totalSeat);
    }
}
