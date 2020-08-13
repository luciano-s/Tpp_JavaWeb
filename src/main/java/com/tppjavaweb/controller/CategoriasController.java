package com.tppjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriasController {
	@GetMapping("/categorias")
	public ModelAndView chamaCategoria() {
		ModelAndView mv = new ModelAndView("categorias");
		return mv;
	}
}
