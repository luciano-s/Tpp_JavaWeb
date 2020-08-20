package com.tppjavaweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tppjavaweb.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
