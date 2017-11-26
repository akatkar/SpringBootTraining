package com.akatkar.spring.securitydemo.repo;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ali Katkar
 */
public interface BookingRepository extends JpaRepository<HotelBooking, Long>{
    
}
