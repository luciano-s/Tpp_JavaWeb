package com.tppjavaweb.controller;

import java.util.ArrayList;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Serie;
import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.repository.Series;
import com.tppjavaweb.repository.Usuarios;

@Controller
public class MinhasAvaliacoesController {
	@Autowired
	private Series series;
	@Autowired
	private Usuarios usuarios;
	private final Integer elementos_por_pagina = 1;

	@RequestMapping("/minhas-avaliacoes")
	public ModelAndView chamaMinhasAvaliacoes(Model model, @RequestParam(defaultValue = "0") Integer pageNo) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return new ModelAndView("redirect:login");
		}
		Usuario user = usuarios.findByEmail(authentication.getName());
		if(user == null) {
			return new ModelAndView("redirect:login");
		}
		Long id = (long) user.getId();
		
		ModelAndView mv = new ModelAndView("minhas-avaliacoes");
		
		Pageable page = PageRequest.of(pageNo, elementos_por_pagina);

		ArrayList<Long> sIds = (ArrayList<Long>) usuarios.findSerieIdByUsuarioId(id);

		Long total = (long) sIds.size();
		ArrayList<PaginaController> paginas = PaginaController.gerarPaginas(pageNo, elementos_por_pagina, total);

		ArrayList<Serie> resultSet = new ArrayList<Serie>();
		if (sIds.size() != 0) {
			resultSet = (ArrayList<Serie>) series.findByIds(sIds, page);
		}
		
		model.addAttribute("series", resultSet);
		model.addAttribute("user", user);
		model.addAttribute("paginas", paginas);
		model.addAttribute("total", total);
		return mv;
	}
}
