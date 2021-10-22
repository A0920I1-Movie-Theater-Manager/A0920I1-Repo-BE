package com.service;

import com.model.entity.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceService  {
    List<Price> getAll();
}
