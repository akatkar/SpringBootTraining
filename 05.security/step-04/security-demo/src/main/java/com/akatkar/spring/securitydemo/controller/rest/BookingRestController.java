package com.akatkar.spring.securitydemo.controller.rest;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.repo.BookingRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ali Katkar
 */
@RestController
@RequestMapping("/rest")
public class BookingRestController {
    
    @Autowired
    private BookingRepository bookingRepository;
    
//    @Secured("ROLE_USER")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/{index}")
    public HotelBooking getByIndex(@PathVariable int index){
        return bookingRepository.getBookings().get(index);
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping("/all")
    public List<HotelBooking> getAll(){
        return bookingRepository.getBookings();
    }
    
    @PostMapping("/add")
    public List<HotelBooking> addBooking(@RequestBody HotelBooking hotelBooking){
        bookingRepository.getBookings().add(hotelBooking);
        return bookingRepository.getBookings();
    }
    
    @DeleteMapping("/delete/{id}")
    public List<HotelBooking> deleteBooking(@PathVariable int id){
        bookingRepository.getBookings().remove(id);
        return bookingRepository.getBookings();
    }
    
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookingRepository.getBookings()
               .stream()
                .filter(x->x.getPricePerNight()<=price)
                .collect(Collectors.toList());
    }
}
