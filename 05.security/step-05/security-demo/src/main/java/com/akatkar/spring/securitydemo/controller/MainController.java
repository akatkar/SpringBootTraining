package com.akatkar.spring.securitydemo.controller;

import org.springframework.stereotype.Controller;
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
}
