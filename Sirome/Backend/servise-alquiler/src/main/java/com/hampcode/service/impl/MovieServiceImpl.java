package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.Movie;
import com.hampcode.repository.MovieRepository;
import com.hampcode.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
    @Transactional
	@Override
	public Movie insertOrUpdate(Movie entity) {
		return movieRepository.save(entity);
	}

	@Override
	public Optional<Movie> getOne(Long id) {
		return movieRepository.findById(id);
	}

	@Override
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> findAllByGenders_Id(Long id) {
		return movieRepository.findAllByGenders_Id(id);
	}
	
	
	
	
}
