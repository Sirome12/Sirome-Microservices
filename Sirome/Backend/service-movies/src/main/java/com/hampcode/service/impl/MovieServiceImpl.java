package com.hampcode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Movie;
import com.hampcode.model.repository.MovieRepository;
import com.hampcode.service.MovieService;


@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAll() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().iterator().forEachRemaining(movies::add);
		return movies;
	}
	
	@Override
	public Optional<Movie>getOne(Long id) {
		return movieRepository.findById(id);
	}

	@Transactional
	@Override
	public Movie create(Movie entity) {
		return movieRepository.save(entity);
	}



	@Transactional
	@Override
	public void deleteById(Long id) {

		movieRepository.deleteById(id);

	}

	@Override
	public Movie insertOrUpdate(Movie entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
