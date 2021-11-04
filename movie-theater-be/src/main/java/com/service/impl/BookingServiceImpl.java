package com.service.impl;

import com.repository.BookingRepository;
import com.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    //    TuHC - book ve
    @Override
    public void saveBooking(String bookingCode, int point, int received, double totalPrice, long accountId, long paymentId, long promotionId) {
        bookingRepository.saveBooking(bookingCode, point, received, totalPrice, accountId, paymentId, promotionId);
    }

    //TuHC - book ve
    @Override
    public void saveBookingSeat(long bookingId, long seatId) {
        bookingRepository.saveBookingSeat(bookingId, seatId);
    }
}
