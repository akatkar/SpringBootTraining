package com.btc.spring.webdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/booking")
public class BookingController {

	
	@RequestMapping("/hello")
	public String getBooking(Model model) {
		model.addAttribute("mode","ilk modelim");
		return "index";
	}
	
	@GetMapping("/hello2")
	public ModelAndView getBooking2() {
		
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("mode", "model and view");
		
		return modelAndView;
	}
}
