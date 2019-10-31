package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.User;
import com.hampcode.repository.UserRepository;
import com.hampcode.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
    @Transactional
	@Override
	public User insertOrUpdate(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public Optional<User> getOne(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
}
