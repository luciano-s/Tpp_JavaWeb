package com.tppjavaweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tppjavaweb.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

}
