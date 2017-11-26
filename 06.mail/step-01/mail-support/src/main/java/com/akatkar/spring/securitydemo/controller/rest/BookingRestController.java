package com.akatkar.spring.securitydemo.controller.rest;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.repo.BookingRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/{index}")
    public HotelBooking getByIndex(@PathVariable int index){
        return bookingRepository.findAll().get(index);
    }
    
    @GetMapping("/all")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }
    
    @PostMapping("/add")
    public List<HotelBooking> addBooking(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }
    
    @DeleteMapping("/delete/{id}")
    public List<HotelBooking> deleteBooking(@PathVariable Long id){
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }
    
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookingRepository.findAll()
               .stream()
                .filter(x->x.getPricePerNight()<=price)
                .collect(Collectors.toList());
    }
}
