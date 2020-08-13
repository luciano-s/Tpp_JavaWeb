package com.tppjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.repository.Usuarios;

@Controller
public class CadastroUsuarioController {
	@Autowired
	private Usuarios usuarios;
	
	@GetMapping("/cadastro")
	public String chamaCadastraUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "cadastro";
	}
	
	@RequestMapping(value="/cadastra-usuario", method=RequestMethod.POST)
	public String cadastraUsuario(@ModelAttribute("usuario") Usuario usuario) {
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		this.usuarios.save(usuario);
		return "index";
	}
	
	@GetMapping("/categorias")
	public ModelAndView chamaCategoria() {
		ModelAndView mv = new ModelAndView("categorias");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView chamaLogin() {
		ModelAndView mv = new ModelAndView("login2");
		return mv;
	}
	
	
}
