package com.tppjavaweb.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.model.Serie;
import com.tppjavaweb.repository.Categorias;
import com.tppjavaweb.repository.Series;

import antlr.collections.List;

@Controller
public class CategoriasController {
	@Autowired
	private Categorias categorias;
	@Autowired
	private Series series;
	@GetMapping("/categorias")
	public ModelAndView getCategorias(Model model) {
		ModelAndView mv = new ModelAndView("categorias");
		ArrayList<Categoria>cat = new ArrayList<Categoria>(categorias.findAll());
		model.addAttribute("categ", cat);
		return mv;
	}
	
	@RequestMapping("{id}/categoria-serie")
	public ModelAndView getSeriesByCategoria(@PathVariable Long id, Model model) {
		System.out.println("Entrou na rota");
		ArrayList<Long> A = (ArrayList<Long>)categorias.findSerieIdByCategoriaId(id);
		ArrayList<Serie> resultSet = (ArrayList<Serie>)series.findAllById(A);
		for (Serie rs: resultSet)System.out.println(rs.getNome());
		model.addAttribute("series", resultSet);
		ModelAndView mv = new ModelAndView("resultado-busca");
		return mv;
	}
	
}
