package com.tppjavaweb.controller;

import java.util.ArrayList;


public class PaginaController{
	public Integer pagina;
	public boolean ativa;
	public PaginaController(Integer pagina, boolean ativa) {
		super();
		this.pagina = pagina;
		this.ativa = ativa;
	}
	public static ArrayList<PaginaController> gerarPaginas(Integer atual, Integer elementos_por_pagina, Long total) {
		ArrayList<PaginaController> paginas = new ArrayList<PaginaController>();
		Integer numPages = (int) Math.ceil(total / (double)elementos_por_pagina);
		System.out.println(numPages);
		
		if(total == 0 || (total-elementos_por_pagina) <= 0) return paginas;
		
		for (int i = 0; i < numPages; i++) {
			boolean ativa = (i == atual) ? true : false;
			paginas.add(new PaginaController(i, ativa));
		}
		return paginas;
	}
}