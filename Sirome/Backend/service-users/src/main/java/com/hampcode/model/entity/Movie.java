package com.hampcode.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.hampcode.model.entity.Account;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String slogan;
	private String trailer;
	private Long imdb_id;
	private String sinopsis;
	private int duration;
	private int views;
	private String source;
	private float rental_price;
	private Date release_date;
	private String post_url;
	private Date publish_date;
	private String backdrop_url;
	
	@ManyToMany
	@JoinTable(
	  name = "movies_genders", 
	  joinColumns = @JoinColumn(name = "movie_id"), 
	  inverseJoinColumns = @JoinColumn(name = "gender_id"))
	private Set<Gender> genders = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;
	
	@ManyToMany(mappedBy = "moviesWishlist")
	private Set<Account> usersWishList;
	
	@PrePersist
	public void init() {
		this.publish_date = new Date();
	}
	
	public Movie() {
		reviews=new ArrayList<Review>();
	}

	public Movie(Long id, String name, String slogan, String trailer, Long imdb_id, String sinopsis, int duration,
			int views, String source, float rental_price, String released_date, String post_url, String backdrop_url, Set<Gender> genders) throws ParseException {
		super();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.id = id;
		this.name = name;
		this.slogan = slogan;
		this.trailer = trailer;
		this.imdb_id = imdb_id;
		this.sinopsis = sinopsis;
		this.duration = duration;
		this.views = 0;
		this.source = source;
		this.rental_price = rental_price;
		this.post_url = post_url;
		this.release_date = format.parse(released_date);
		this.setBackdrop_url(backdrop_url);
		this.genders = genders;
	}
	
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
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getPost_url() {
		return post_url;
	}
	public void setPost_url(String post_url) {
		this.post_url = post_url;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Set<Gender> getGenders() {
		return this.genders;
	}
	public void setGenders(Set<Gender> genders) {
		this.genders = genders;
	}

	public String getBackdrop_url() {
		return backdrop_url;
	}

	public void setBackdrop_url(String backdrop_url) {
		this.backdrop_url = backdrop_url;
	}

}
