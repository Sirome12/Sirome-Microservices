package com.hampcode.api.viewmodel;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.hampcode.model.Gender;

public class MovieViewModel {

	private Long id;
	@NotNull
	private String name;
	private String slogan;
	private String trailer;
	private Long imdb_id;
	private String sinopsis;
	private int duration;
	private int views;
	private String source;
	private float rental_price;
	private String release_date;
	private String poster_url;
	private String backdrop_url;
	private List<Long> gendersIds;
	
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
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String date) {
		this.release_date = date;
	}
	public String getPoster_url() {
		return poster_url;
	}
	public void setPoster_url(String poster_url) {
		this.poster_url = poster_url;
	}
	public List<Long> getGendersIds() {
		return gendersIds;
	}
	public void setGenders(List<Long> gendersIds) {
		this.gendersIds = gendersIds;
	}
	public String getBackdrop_url() {
		return backdrop_url;
	}
	public void setBackdrop_url(String backdrop_url) {
		this.backdrop_url = backdrop_url;
	}
}
