package com.tppjavaweb.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Serie;
import com.tppjavaweb.repository.Series;

@Controller
public class RecomendacaoController {
	@Autowired
	Series series;
	
	@RequestMapping("/recomendacao")
	public ModelAndView recomendacao() {

		ArrayList<Serie> arrSeries = (ArrayList<Serie>)series.findAll();
		int max = arrSeries.size();
		int n = new Random().nextInt(max);
		System.out.println(max);
		Serie serie = arrSeries.get(n);
		System.out.println(serie.getNome());

		return new ModelAndView("redirect:/buscar?s="+serie.getNome());
		
	}
}
