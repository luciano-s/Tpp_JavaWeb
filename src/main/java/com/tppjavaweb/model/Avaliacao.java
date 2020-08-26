package com.tppjavaweb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue
	@Column(name="idComentario")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="usuario_id")
	Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serie_id")
	Serie serie;
	
	@Column(name="texto")
	private String texto;
	@Column(name="notaGeral")
	private int notaGeral;
	@Column(name="notaHistoria")
	private int notaHistoria;
	@Column(name="notaSonora")
	private int notaSonora;
	@Column(name="notaPersonagem")
	private int notaPersonagem;
	@Column(name="notaDirecao")
	private int notaDirecao;
	@Column(name="numeroLikes")
	private int numeroLikes;
	
	@Transient
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getNotaGeral() {
		return notaGeral;
	}
	public void setNotaGeral(int notaGeral) {
		this.notaGeral = notaGeral;
	}
	public int getNotaHistoria() {
		return notaHistoria;
	}
	public void setNotaHistoria(int notaHistoria) {
		this.notaHistoria = notaHistoria;
	}
	public int getNotaSonora() {
		return notaSonora;
	}
	public void setNotaSonora(int notaSonora) {
		this.notaSonora = notaSonora;
	}
	public int getNotaPersonagem() {
		return notaPersonagem;
	}
	public void setNotaPersonagem(int notaPersonagem) {
		this.notaPersonagem = notaPersonagem;
	}
	public int getNotaDirecao() {
		return notaDirecao;
	}
	public void setNotaDirecao(int notaDirecao) {
		this.notaDirecao = notaDirecao;
	}
	public int getNumeroLikes() {
		return numeroLikes;
	}
	public void setNumeroLikes(int numeroLikes) {
		this.numeroLikes = numeroLikes;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
