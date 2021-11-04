package com.controller;

import com.model.dto.BookingDTO;
import com.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/booking")
@CrossOrigin("http://localhost:4200")
public class BookingTicketController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/add-booking")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO[] bookingDTOs) {
        for (BookingDTO bookingDTO : bookingDTOs) {
            bookingService.saveBooking(bookingDTO.getBookingCode(), bookingDTO.getPoint(), bookingDTO.getReceived(),
                    bookingDTO.getTotalPrice(), bookingDTO.getAccount(), bookingDTO.getPayment(), bookingDTO.getPromotion());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
