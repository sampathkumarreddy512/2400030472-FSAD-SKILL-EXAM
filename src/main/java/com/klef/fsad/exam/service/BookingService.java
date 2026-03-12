package com.klef.fsad.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.fsad.exam.entity.Booking;
import com.klef.fsad.exam.repo.BookingRepository;
import java.util.List;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }
    
    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
    
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
