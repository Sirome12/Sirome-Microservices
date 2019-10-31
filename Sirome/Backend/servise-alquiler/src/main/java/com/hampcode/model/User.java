package com.hampcode.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastname;
	private String profile_img_url;
	private String email;
	private String birthday;
	private String password;
	private Boolean subscription_status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;

	@ManyToMany
	@JsonIgnore
	@JoinTable(
	  name = "users_wl_movies", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> moviesWishlist = new HashSet<>();

	public User() {
		reviews=new ArrayList<Review>();
	}
	
	public User(Long id, String name, String lastname, String birthday, String password, String email, String profile_img_url) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.birthday = birthday;
		this.password = password;
		this.email = email;
		this.profile_img_url = profile_img_url;
		this.subscription_status = false;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile_img_url() {
		return profile_img_url;
	}

	public void setProfile_img_url(String profile_img_url) {
		this.profile_img_url = profile_img_url;
	}

	public Boolean getSubscription_status() {
		return subscription_status;
	}

	public void setSubscription_status(Boolean subscription_status) {
		this.subscription_status = subscription_status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public Set<Movie> getMoviesWishlist() {
		return moviesWishlist;
	}

	public void setMoviesWishlist(Set<Movie> moviesWishlist) {
		this.moviesWishlist = moviesWishlist;
	}
}
