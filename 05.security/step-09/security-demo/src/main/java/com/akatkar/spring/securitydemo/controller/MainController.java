package com.akatkar.spring.securitydemo.controller;

import com.akatkar.spring.securitydemo.model.CurrentUser;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ali Katkar
 */
@Controller
public class MainController {
    
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
}
