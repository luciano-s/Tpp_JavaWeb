package com.tppjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping("/index")
	public ModelAndView chamaIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
