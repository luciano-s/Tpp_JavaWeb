package com.tppjavaweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Serie implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private int temporadas;
	private int episodios;
	private float nota;
	private int classificacaoInd;
	private String descricao;
	private String caminhoImagem;
	private String caminhoTrailer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	public int getEpisodios() {
		return episodios;
	}
	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getClassificacaoInd() {
		return classificacaoInd;
	}
	public void setClassificacaoInd(int classificacaoInd) {
		this.classificacaoInd = classificacaoInd;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	public String getCaminhoTrailer() {
		return caminhoTrailer;
	}
	public void setCaminhoTrailer(String caminhoTrailer) {
		this.caminhoTrailer = caminhoTrailer;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	
}
