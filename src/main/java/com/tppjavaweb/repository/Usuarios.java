package com.tppjavaweb.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tppjavaweb.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
	Usuario findById(Integer id);
	@Query(nativeQuery = true, value = "SELECT serie_id FROM usuario_serie WHERE usuario_id=?1")
    ArrayList<Long> findSerieIdByUsuarioId(Long id);
}
