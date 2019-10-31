package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.Gender;
import com.hampcode.repository.GenderRepository;
import com.hampcode.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService{
	
	@Autowired
	private GenderRepository genderRepository;
	
    @Transactional
	@Override
	public Gender insertOrUpdate(Gender entity) {
		return genderRepository.save(entity);
	}

	@Override
	public Optional<Gender> getOne(Long id) {
		return genderRepository.findById(id);
	}
	
	@Override
	public List<Gender> getAll() {
		return genderRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		genderRepository.deleteById(id);
	}

	
	
}
