package com.tppjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MinhasAvaliacoesController {
	
	@GetMapping("/minhas-avaliacoes")
	public ModelAndView chamaMinhasAvaliacoes() {
		ModelAndView mv = new ModelAndView("minhas-avaliacoes");
		return mv;
	}
}
