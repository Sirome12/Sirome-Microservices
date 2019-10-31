package com.hampcode.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable = false,length = 70)
	private String name;
	
	@Column(name="slogan", nullable = false,length = 70)
	private String slogan;
	
	@Column(name="trailer", nullable = false,length = 70)
	private String trailer;
	
	@Column(name="imdb_id", nullable = false)
	private Long imdb_id;
	
	@Column(name="sinopsis", nullable = false,length = 70)
	private String sinopsis;
	
	@Column(name="duration", nullable = false)
	private int duration;
	
	@Column(name="views", nullable = false)
	private int views;
	
	@Column(name="source", nullable = false,length = 70)
	private String source;
	
	@Column(name="rental_price", nullable = false)
	private float rental_price;
	
	@Transient
	private Integer port;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public Long getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(Long imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public float getRental_price() {
		return rental_price;
	}

	public void setRental_price(float rental_price) {
		this.rental_price = rental_price;
	}
	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
