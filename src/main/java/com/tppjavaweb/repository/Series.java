package com.tppjavaweb.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.tppjavaweb.model.Serie;


public interface Series extends PagingAndSortingRepository<Serie, Long>{
	ArrayList<Serie> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT * FROM serie WHERE id IN :ids")
	ArrayList<Serie> findByIds(@Param("ids") ArrayList<Long> ids, Pageable pageable);
	Long countByNomeContainingIgnoreCase(String nome);
	ArrayList<Serie> findByCategoriaId(Long id);
//	ArrayList<Serie> findByNomeContainingIgnoreCase(String nome);
	
	@Query(nativeQuery = true, value = "SELECT elenco_id FROM elenco_serie WHERE serie_id=?1")
    ArrayList<Long> findElencoIdBySerieId(Long id);
	
}
