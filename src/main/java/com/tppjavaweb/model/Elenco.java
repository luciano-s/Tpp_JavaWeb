package com.tppjavaweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="elenco")
public class Elenco {
	private static final long SerialVersionUID = 1L;
	
	@Id	
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="funcao")
	private String funcao;
	@Column(name="caminhoImagem")
	private String caminhoImagem;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "elenco_serie",
    joinColumns = @JoinColumn(name = "elenco_id"), inverseJoinColumns = @JoinColumn(name = "serie_id"))
	private Set<Serie> serie = new HashSet<>();
	
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Set<Serie> getSerie() {
		return serie;
	}

	public void setSerie(Set<Serie> serie) {
		this.serie = serie;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	
}
