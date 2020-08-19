package com.tppjavaweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Categoria implements Serializable{
	private static final long SerialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
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
	
}
