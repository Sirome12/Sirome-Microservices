package com.hampcode.service;

import com.hampcode.model.Review;

import java.util.List;

import com.hampcode.model.Movie;
import com.hampcode.model.User;

public interface ReviewService extends CrudService<Review> {
	
	List<Review> getByMovie(Movie movie);
	List<Review> getByUser(User user);
	
}
