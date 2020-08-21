package com.tppjavaweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.model.Serie;
import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.repository.Series;
import com.tppjavaweb.repository.Usuarios;

@Controller
public class PesquisaSerieController {
	@Autowired
	private Series series;
	private final Integer elementos_por_pagina = 2;
	
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public ModelAndView chamaPesquisaSeries(Model model, 
			@RequestParam("s") String s, 
			 @RequestParam(defaultValue = "0") Integer pageNo) {
		
		ModelAndView mv = new ModelAndView("resultado-busca");
		Pageable page = PageRequest.of(pageNo, elementos_por_pagina);
		ArrayList<Serie>ser = new ArrayList<Serie>(series.findByNomeContainingIgnoreCase(s, page));
		Long total = series.countByNomeContainingIgnoreCase(s);
		ArrayList<Pagina> paginas = gerarPaginas(pageNo, elementos_por_pagina, total);
		model.addAttribute("busca", s);
		model.addAttribute("series", ser);
		model.addAttribute("paginas", paginas);
		model.addAttribute("total", paginas.size());
		
		return mv;
	}
	private class Pagina{
		public Integer pagina;
		public boolean ativa;
		public Pagina(Integer pagina, boolean ativa) {
			super();
			this.pagina = pagina;
			this.ativa = ativa;
		}
	}
	private ArrayList<Pagina> gerarPaginas(Integer atual, Integer elementos_por_pagina, Long total) {
		ArrayList<Pagina> paginas = new ArrayList<Pagina>();
		Integer numPages = (int) Math.ceil(total / (double)elementos_por_pagina);
		System.out.println(numPages);
		
		if(total == 0 || (total-elementos_por_pagina) <= 0) return paginas;
		
		for (int i = 0; i < numPages; i++) {
			boolean ativa = (i == atual) ? true : false;
			paginas.add(new Pagina(i, ativa));
		}
		return paginas;
	}
}
