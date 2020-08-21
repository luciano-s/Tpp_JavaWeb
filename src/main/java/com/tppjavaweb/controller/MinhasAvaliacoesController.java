package com.tppjavaweb.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
//	@RequestMapping("/minhas-avaliacoes/{id}")
	@RequestMapping("/minhas-avaliacoes")
//	public ModelAndView chamaMinhasAvaliacoes(@PathVariable Long id,  Model model) {
	public ModelAndView chamaMinhasAvaliacoes(Model model) {
		Long id = (long) 1;
		ModelAndView mv = new ModelAndView("minhas-avaliacoes");
		ArrayList<Long> sIds = (ArrayList<Long>)usuarios.findSerieIdByUsuarioId(id);
		ArrayList<Serie> resultSet = (ArrayList<Serie>)series.findAllById(sIds);
		for (Serie rs: resultSet)System.out.println(rs.getNome());
		Usuario u = usuarios.findById(id.intValue());
		model.addAttribute("series", resultSet);
		model.addAttribute("user", u);
		return mv;
	}
}
