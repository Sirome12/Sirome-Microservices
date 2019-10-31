package com.hampcode.api.viewmodel;

public class UserViewModel {
	
	private Long id;
	
	private String name;
	private String lastname;
	private String profile_img_url;
	private String email;
	private String birthday;
	private String password;
	private Boolean subscription_status;
	
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
	public String getProfile_img_url() {
		return profile_img_url;
	}
	public void setProfile_img_url(String profile_img_url) {
		this.profile_img_url = profile_img_url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Boolean getSubscription_status() {
		return subscription_status;
	}
	public void setSubscription_status(Boolean subscription_status) {
		this.subscription_status = subscription_status;
	}
	
	
}
