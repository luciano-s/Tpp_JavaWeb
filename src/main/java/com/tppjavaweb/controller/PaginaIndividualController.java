package com.tppjavaweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Serie;
import com.tppjavaweb.repository.Series;

@Controller
public class PaginaIndividualController {

	@Autowired
	private Series series;
	
	@GetMapping("/pagina-individual/{id}")
	public ModelAndView chamaPaginaIndividual(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("pagina-individual");
		
		
		Optional<Serie> optionalEntity =  series.findById(id);
		System.out.println((series.findById(id)).get().getCaminhoImagem());
		Serie serie = optionalEntity.get();
		mv.addObject(serie);
		
		
		
		return mv;
	}
	
}
