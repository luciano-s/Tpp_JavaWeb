package com.tppjavaweb.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tppjavaweb.model.Categoria;

@SuppressWarnings("serial")
@Entity
@Table(name = "serie")
public class Serie implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "temporadas")
	private int temporadas;
	@Column(name = "episodios")
	private int episodios;
	@Column(name = "nota")
	private float nota;
	@Column(name = "classificacaoInd")
	private int classificacaoInd;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "caminhoImagem")
	private String caminhoImagem;
	@Column(name = "caminhoTrailer")
	private String caminhoTrailer;
	@ManyToMany(mappedBy = "serie", cascade = CascadeType.MERGE)
	private Set<Categoria> categoria = new HashSet<>();
	@ManyToMany(mappedBy = "serie", cascade = CascadeType.MERGE)
	private Set<Usuario> usuarios = new HashSet<>();
//	@ManyToMany(mappedBy = "serie", cascade = CascadeType.MERGE)
//	private Set<Elenco> elenco = new HashSet<>();
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
