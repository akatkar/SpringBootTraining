package com.akatkar.spring.securitydemo.controller;

import com.akatkar.spring.securitydemo.model.CurrentUser;
import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.observer.BookingEventPublisher;
import com.akatkar.spring.securitydemo.repo.BookingRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Ali Katkar
 */
@Controller
public class MainController {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private BookingEventPublisher bookingEventPublisher;
    
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }
    
    @GetMapping("/users")
    public String getUser(@AuthenticationPrincipal Principal principal, Model model){
        
        CurrentUser activeUser = (CurrentUser) ((Authentication) principal).getPrincipal();
        model.addAttribute("activeUser", activeUser.getUser());
        return "index";
    }
    
    @GetMapping("/mail/{id}")
    public String getUser(@PathVariable Long id){
        
        HotelBooking booking = bookingRepository.findOne(id);
        System.out.println("-----------> " + Thread.currentThread().getName());
        bookingEventPublisher.sendPublishEvent(booking);        
        return "index";
    }
}
