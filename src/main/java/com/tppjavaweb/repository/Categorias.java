package com.tppjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.tppjavaweb.model.Categoria;



public interface Categorias extends JpaRepository<Categoria, Long>{
	@Query("SELECT idSerie  FROM Serie_CAtegoria WHERE idCategoria=?1")
	List<Long> findIdSeriesByCategory(Long catId);	
}
