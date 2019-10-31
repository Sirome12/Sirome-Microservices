package com.hampcode.api;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.api.viewmodel.ReviewViewModel;
import com.hampcode.model.Review;
import com.hampcode.model.User;
import com.hampcode.model.Movie;
import com.hampcode.service.UserService;
import com.hampcode.service.ReviewService;
import com.hampcode.service.MovieService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	
	@Autowired
	private ReviewService reviewService;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<ReviewViewModel> all() {
		List<Review> reviews = this.reviewService.getAll();

		// map from entity to view model
		List<ReviewViewModel> reviewsViewModel = reviews.stream().map(review -> this.mapper.convertToReviewViewModel(review))
				.collect(Collectors.toList());

		return reviewsViewModel;
	}

	@GetMapping("/{id}")
	public ReviewViewModel byId(@PathVariable Long id) {
		Optional<Review> review = this.reviewService.getOne(id);

		if (!review.isPresent()) {
			throw new EntityNotFoundException();
		}

		ReviewViewModel reviewViewModel = this.mapper.convertToReviewViewModel(review.get());

		return reviewViewModel;
	}

	@GetMapping("/byUser/{userId}")
	public List<ReviewViewModel> byUser(@PathVariable Long userId) {
		List<Review> reviews = new ArrayList<>();

		Optional<User> user = this.userService.getOne(userId);
		if (user.isPresent()) {
			reviews = this.reviewService.getByUser(user.get());
		}

		// map to note view model
		List<ReviewViewModel> reviewsViewModel = reviews.stream().map(review -> this.mapper.convertToReviewViewModel(review))
				.collect(Collectors.toList());

		return reviewsViewModel;
	}
	
	@GetMapping("/byMovie/{movieId}")
	public List<ReviewViewModel> byNotebook(@PathVariable Long movieId) {
		List<Review> reviews = new ArrayList<>();

		Optional<Movie> movie = this.movieService.getOne(movieId);
		if (movie.isPresent()) {
			reviews = this.reviewService.getByMovie(movie.get());
		}

		// map to note view model
		List<ReviewViewModel> reviewsViewModel = reviews.stream().map(review -> this.mapper.convertToReviewViewModel(review))
				.collect(Collectors.toList());

		return reviewsViewModel;
	}

	@PostMapping
	public Review save(@RequestBody ReviewViewModel reviewCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Review reviewEntity = this.mapper.converToReviewEntity(reviewCreateViewModel);

		// save note instance to db
		this.reviewService.insertOrUpdate(reviewEntity);

		return reviewEntity;
	}

	@PutMapping
	public Review update(@RequestBody ReviewViewModel reviewCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Review reviewEntity = this.mapper.converToReviewEntity(reviewCreateViewModel);

		// save note instance to db
		this.reviewService.insertOrUpdate(reviewEntity);

		return reviewEntity;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.reviewService.delete(id);
	}

}