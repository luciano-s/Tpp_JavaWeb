package com.tppjavaweb.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="categoria")
public class Categoria implements Serializable{
	private static final long SerialVersionUID = 1L;
	@Id	
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="nome")
	private String nome;
	
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "categoria_serie",
    joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "serie_id"))
	private Set<Serie> serie = new HashSet<>();
	
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
