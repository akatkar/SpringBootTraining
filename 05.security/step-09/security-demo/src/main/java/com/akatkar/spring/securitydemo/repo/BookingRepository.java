package com.akatkar.spring.securitydemo.repo;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ali Katkar
 */
@Component
public class BookingRepository {
    
    private List<HotelBooking> bookings;

    public List<HotelBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<HotelBooking> bookings) {
        this.bookings = bookings;
    }
}
