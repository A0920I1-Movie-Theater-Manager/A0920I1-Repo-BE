package com.service;

import com.model.entity.Price;

import java.util.List;

public interface PriceService {
    void addPriceMovie(String time, String day, boolean is3D,double price);
    List<Price> listPrice();
}
