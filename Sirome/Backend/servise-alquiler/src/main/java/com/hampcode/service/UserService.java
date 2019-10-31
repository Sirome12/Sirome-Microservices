package com.hampcode.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hampcode.model.User;

public interface UserService extends CrudService<User> {
	
	User getByEmail(String email);

}
