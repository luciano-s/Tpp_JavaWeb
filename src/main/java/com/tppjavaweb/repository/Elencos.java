package com.tppjavaweb.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tppjavaweb.model.Elenco;

public interface Elencos extends JpaRepository<Elenco, Long>{
		
	
}
