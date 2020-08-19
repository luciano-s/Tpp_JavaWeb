package com.tppjavaweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.repository.Categorias;

import antlr.collections.List;

@Controller
public class CategoriasController {
	@Autowired
	private Categorias categorias;
//	@GetMapping("/categorias")
//	public ModelAndView chamaCategoria() {
//		ModelAndView mv = new ModelAndView("categorias");
//		return mv;
//	}
	
	@GetMapping("/categorias")
	public ModelAndView getCategorias(Model model) {
		ModelAndView mv = new ModelAndView("categorias");
//		System.out.println("Categorias: ");
		ArrayList<Categoria>cat = new ArrayList<Categoria>(categorias.findAll());
//		for (Categoria c : cat) {
//			System.out.println("Nome: "+c.getNome()+" id: "+c.getId());
//		}
		model.addAttribute("categ", cat);
		return mv;
	}
	
}
