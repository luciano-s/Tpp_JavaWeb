package com.tppjavaweb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Serie;
import com.tppjavaweb.model.SliderItem;
import com.tppjavaweb.repository.Series;
import com.tppjavaweb.repository.Slider;

@Controller
public class IndexController {
	@Autowired
	private Series series;
	@Autowired
	private Slider slider;
	
	@GetMapping("/")
	public ModelAndView chamaIndex(Model model) {
		ModelAndView mv = new ModelAndView("index");
		ArrayList<Serie> populares = series.getSeriesPopulares(9);
		ArrayList<SliderItem> sliderItens = (ArrayList<SliderItem>) slider.findAll(); 
		model.addAttribute("series", populares);
		model.addAttribute("sliderItens", sliderItens);
		return mv;
	}
}
