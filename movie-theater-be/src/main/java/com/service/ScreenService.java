package com.service;

import com.model.entity.Screen;

import java.util.List;

public interface ScreenService {
    List<Screen> getAllScreen();

    Screen findById(long id);

    List<Screen> searchName(String name);

    void createScreen(String name, int totalSeat);
}
