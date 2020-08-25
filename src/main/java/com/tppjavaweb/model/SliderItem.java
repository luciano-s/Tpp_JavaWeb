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
@Table(name="slider")
public class SliderItem implements Serializable{
	private static final long SerialVersionUID = 1L;
	@Id	
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="src")
	private String src;
	
	public 	SliderItem() {}
	
	public SliderItem(int i, String src) {
		this.id = (long) i;
		this.src = src;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	public void getSeriesByCategoryId() {
		
	}
}
