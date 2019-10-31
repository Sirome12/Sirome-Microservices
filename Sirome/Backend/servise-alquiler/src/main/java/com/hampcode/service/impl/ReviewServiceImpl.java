package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.Review;
import com.hampcode.model.Movie;
import com.hampcode.model.User;
import com.hampcode.repository.ReviewRepository;
import com.hampcode.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Transactional
	@Override
	public Review insertOrUpdate(Review entity) {
		return reviewRepository.save(entity);
	}

	@Override
	public Optional<Review> getOne(Long id) {
		return reviewRepository.findById(id);
	}

	@Override
	public List<Review> getAll() {
		return reviewRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		reviewRepository.deleteById(id);
	}

	@Override
	public List<Review> getByUser(User user) {
		return reviewRepository.findAllByUser(user);
	}

	@Override
	public List<Review> getByMovie(Movie movie) {
		return reviewRepository.findAllByMovie(movie);
	}
	
	

}
