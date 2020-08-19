package com.tppjavaweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.repository.Categorias;
@Controller
public class CadastroCategoriasController {
	@Autowired
	private Categorias categorias;

	
	@RequestMapping("cadastro-categoria")
	public String inserCat() {
		ArrayList<Categoria> arr = new ArrayList();
		arr.add(new Categoria(1, "Ação"));
		arr.add(new Categoria( 2, "Animação"));
		arr.add(new Categoria( 3, "Aventura"));
		arr.add(new Categoria( 4, "Catástrofe"));
		arr.add(new Categoria( 5, "Comédia"));
		arr.add(new Categoria( 6, "Comédia Romântica"));
		arr.add(new Categoria( 7, "Comédia Dramática"));
		arr.add(new Categoria( 8, "Comédia de Ação"));
		arr.add(new Categoria( 9, "Crime"));
		arr.add(new Categoria( 10, "Cult"));
		arr.add(new Categoria( 11, "Documentário"));
		arr.add(new Categoria( 12, "Drama"));
		arr.add(new Categoria( 13, "Fantasia"));
		arr.add(new Categoria( 14, "Western"));
		arr.add(new Categoria( 15, "SciFi"));
		arr.add(new Categoria( 16, "Guerra"));
		arr.add(new Categoria( 17, "Musical"));
		arr.add(new Categoria( 18, "Policial"));
		arr.add(new Categoria( 19, "Psicológico"));
		arr.add(new Categoria( 20, "Romance"));
		arr.add(new Categoria( 21, "Suspense"));
		arr.add(new Categoria( 22, "Terror"));
		arr.add(new Categoria( 23, "Thriller"));
		arr.add(new Categoria( 24, "Variedades"));
		System.out.println(arr);
		categorias.saveAll(arr);
		return "redirect:categorias-2";
	}
}
