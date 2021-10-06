package com.service.impl;

import com.model.entity.Price;
import com.repository.PriceRepository;
import com.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceRepository priceRepository;

    @Override
    public void addPriceMovie(String time, String day, boolean is3D, double price) {
        priceRepository.addPriceMovie(time, day, is3D, price);
    }

    @Override
    public List<Price> listPrice() {
        return priceRepository.listPrice();
    }
}
