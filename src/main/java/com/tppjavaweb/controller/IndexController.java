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
import com.tppjavaweb.repository.Series;

@Controller
public class IndexController {
	@Autowired
	private Series series;

	@GetMapping("/")
	public ModelAndView chamaIndex(Model model) {
		ModelAndView mv = new ModelAndView("index");
		ArrayList<Serie> populares = series.getSeriesPopulares(9);
		model.addAttribute("series", populares);
		return mv;
	}
}
