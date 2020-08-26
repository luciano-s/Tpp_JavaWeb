package com.tppjavaweb.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tppjavaweb.model.Avaliacao;

public interface Avaliacoes extends JpaRepository<Avaliacao, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM avaliacao WHERE serie_id=?1 ORDER BY numero_likes")
	ArrayList<Long> findAvaliacoesBySerieId(Long id);

	
	@Query(nativeQuery = true, value = "UPDATE avaliacao SET numero_likes = numero_likes + 1 WHERE id_comentario=?1")
	@Modifying
	void updateAvaliacaoNumLikes(Long id);

}
