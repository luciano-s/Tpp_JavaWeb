package com.tppjavaweb.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Avaliacao;
import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.model.Elenco;
//import com.tppjavaweb.model.Elenco;
import com.tppjavaweb.model.Serie;
import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.repository.Avaliacoes;
import com.tppjavaweb.repository.Categorias;
import com.tppjavaweb.repository.Elencos;
//import com.tppjavaweb.repository.Elencos;
import com.tppjavaweb.repository.Series;
import com.tppjavaweb.repository.Usuarios;

@Controller
public class PaginaIndividualController {

	@Autowired
	private Series series;
	
	@Autowired
	private Elencos elencos;
	
	@Autowired
	private Categorias categorias;
	
	@Autowired
	private Avaliacoes avaliacoes;
	
	@Autowired
	private Usuarios usuarios;
	
	@GetMapping("/pagina-individual/{id}")
	public ModelAndView chamaPaginaIndividual(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("pagina-individual");
		
		
		Optional<Serie> optionalEntity =  series.findById(id);
		System.out.println((series.findById(id)).get().getCaminhoImagem());
		Serie serie = optionalEntity.get();
		mv.addObject(serie);
		
		ArrayList<Long> A = (ArrayList<Long>)series.findElencoIdBySerieId(id);
		ArrayList<Elenco> resultSet = (ArrayList<Elenco>)elencos.findAllById(A);
		for (Elenco rs: resultSet)System.out.println(rs.getNome());
		mv.addObject("elenco", resultSet);
		
		ArrayList<Long> B = (ArrayList<Long>)series.findCategoriaIdBySerieId(id);
		ArrayList<Categoria> resultSet2 = (ArrayList<Categoria>)categorias.findAllById(B);
		String cats = "";
		for (Categoria rs2: resultSet2) {
			System.out.println(rs2.getNome());
			cats = cats + " - " +  rs2.getNome();
		}
		mv.addObject("cats", cats);
		
		ArrayList<Long> C = (ArrayList<Long>)avaliacoes.findAvaliacoesBySerieId(Long.valueOf(id));
		ArrayList<Avaliacao> resultSet3 = (ArrayList<Avaliacao>)avaliacoes.findAllById(C);
		System.out.println("Qtd "+resultSet3.size());
		System.out.println("Avaliacoes: ");
		Usuario u;
		for (Avaliacao rs3: resultSet3) {
			u = usuarios.findById(rs3.getUsuario().getId());
			rs3.setNome(u.getNome());
			System.out.println(rs3.getNome());
		}
		mv.addObject("avaliacoes", resultSet3);
		return mv;
	}
	
	@GetMapping("/pagina-individual/{id}/like")
	public ModelAndView curtirComentario(@PathVariable Long id) {
		//avaliacoes.updateAvaliacaoNumLikes(id);
		return new ModelAndView("redirect:/pagina-individual/{id}");
	}
	
	@PostMapping("/pagina-individual/{id}")
	public ModelAndView avaliar(Avaliacao avaliacao, @PathVariable Long id) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return new ModelAndView("redirect:../login");
		}
		Usuario usuario = usuarios.findByEmail(authentication.getName());
		if(usuario == null) {
			return new ModelAndView("redirect:../login");
		}
		Optional<Serie> serie = series.findById(id);
		avaliacao.setSerie(serie.get());
		avaliacao.setUsuario(usuario);
		this.avaliacoes.save(avaliacao);
		
		return new ModelAndView("redirect:/pagina-individual/{id}");
	}
	
}
