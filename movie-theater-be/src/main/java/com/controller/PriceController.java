package com.controller;

import com.model.entity.Price;
import com.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/auth")
@CrossOrigin("http://localhost:4200")
public class PriceController {
    @Autowired
    private PriceServiceImpl priceService;
    @GetMapping("/prices")
    public ResponseEntity<List<Price>>getPrice() {
        List<Price> priceList = this.priceService.getAll();
        if (priceList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(priceList, HttpStatus.OK);
        }
    }

}
