package com.tppjavaweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.tppjavaweb.model.Categoria;



public interface Categorias extends JpaRepository<Categoria, Long>{
//	@Query("SELECT serie  FROM serie_categoria WHERE categoria_id=?1")
//	List<Long> findIdSeriesByCategory(Long catId);	
    @Query(nativeQuery = true, value = "SELECT serie_id FROM categoria_serie WHERE categoria_id=?1")
    ArrayList<Long> findSerieIdByCategoriaId(Long id);
}
