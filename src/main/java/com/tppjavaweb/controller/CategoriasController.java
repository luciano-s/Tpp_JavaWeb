package com.tppjavaweb.controller;

import java.util.ArrayList;

import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.model.Serie;
import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.repository.Categorias;
import com.tppjavaweb.repository.Series;
import com.tppjavaweb.repository.Usuarios;

import antlr.collections.List;

@Controller
public class CategoriasController {
	@Autowired
	private Categorias categorias;
	@Autowired
	private Series series;
	@Autowired
	private Usuarios usuarios;
	@GetMapping("/categorias")
	public ModelAndView getCategorias(Model model) {
		ModelAndView mv = new ModelAndView("categorias");
		ArrayList<Categoria>cat = new ArrayList<Categoria>(categorias.findAll());
		model.addAttribute("categ", cat);
		return mv;
	}
	
	@RequestMapping("{id}/categoria-serie")
	public ModelAndView getSeriesByCategoria(@PathVariable Long id, Model model,
			@RequestParam(defaultValue = "0") Integer pageNo) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return new ModelAndView("redirect:login");
		}
		Usuario user = usuarios.findByEmail(authentication.getName());
		
		ModelAndView mv = new ModelAndView("busca-serie-id-categoria");
		int elementos_por_pagina = 2;
		
		ArrayList<Long> ids = (ArrayList<Long>)categorias.findSerieIdByCategoriaId(id);
//		ArrayList<Serie> resultSet = (ArrayList<Serie>)series.findAllById(A);
//		for (Serie rs: resultSet)System.out.println(rs.getNome());
//		model.addAttribute("series", resultSet);
		Pageable page = PageRequest.of(pageNo, elementos_por_pagina);
		Long total = (long)ids.size();
		ArrayList<PaginaController> paginas = PaginaController.gerarPaginas(pageNo, elementos_por_pagina, total);
		ArrayList<Serie> resultSet = new ArrayList<Serie>();
		if (ids.size() != 0) {
			resultSet = (ArrayList<Serie>) series.findByIds(ids, page);
		}
		model.addAttribute("categoriaId", id);
		model.addAttribute("series", resultSet);
		model.addAttribute("user", user);
		model.addAttribute("paginas", paginas);
		model.addAttribute("total", paginas.size());
		return mv;
	}
	
	
	
}
