package com.tppjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tppjavaweb.model.Categoria;
import com.tppjavaweb.model.Elenco;

public interface Elencos extends JpaRepository<Elenco, Long>{

}
