package com.klef.fsad.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klef.fsad.exam.entity.Booking;
import com.klef.fsad.exam.service.BookingService;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;
    
    @PostMapping("/add")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.addBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        Booking booking = bookingService.getBookingById(id);
        if(booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        booking.setBookingId(id);
        Booking updatedBooking = bookingService.updateBooking(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }
}
