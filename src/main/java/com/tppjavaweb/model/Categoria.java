package com.tppjavaweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@SuppressWarnings("serial")
@Entity
public class Categoria implements Serializable{
	private static final long SerialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nome;
	
	@ManyToMany
	@JoinTable(name="serie_categoria", joinColumns={@JoinColumn(name="categoria_id")})
	private Set<Serie> serie;
	
	public void setSerie(Set<Serie> serie) {
		this.serie = serie;
	}
	
	public Set<Serie> getSerie(){
		return this.serie;
	}

	public Categoria() {}
	
	public Categoria(int i, String string) {
		this.id = (long) i;
		this.nome = string;
	}
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
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	public void getSeriesByCategoryId() {
		
	}
}
