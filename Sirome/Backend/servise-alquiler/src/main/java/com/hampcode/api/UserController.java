package com.hampcode.api;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.hampcode.Mapper;
import com.hampcode.model.Movie;
import com.hampcode.model.User;
import com.hampcode.api.viewmodel.ReviewViewModel;
import com.hampcode.api.viewmodel.UserViewModel;

import com.hampcode.service.UserService;
import com.hampcode.service.MovieService;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private Mapper mapper;

	
	@GetMapping
	public List<User> all() {
		List<User> movies = this.userService.getAll();
		return movies;
	}
	
	@PutMapping("/{user_id}/addMovieWL/{movie_id}")
	public Boolean addMovieWishlist(@PathVariable Long user_id, @PathVariable Long movie_id) {
		
		Optional<User> user = this.userService.getOne(user_id);
		Optional<Movie> movie = this.movieService.getOne(movie_id);
		
		if(user.isPresent() && movie.isPresent()) {
			Set<Movie> movies = user.get().getMoviesWishlist(); 
			Movie moviep = movie.get();
			movies.add(moviep);
			user.get().setMoviesWishlist(movies);
			this.userService.insertOrUpdate(user.get());
		}
		
		return true;
	}
	
	@GetMapping("/{id}/moviesWishList")
	public Set<Movie> getMoviesWishList(@PathVariable Long id) {
		
		Optional<User> user = this.userService.getOne(id);
		
		Set<Movie> movies = new HashSet<>();
		
		if(user.isPresent()) {
			movies = user.get().getMoviesWishlist();
		}
		
		return movies;
	}

	@PostMapping
	public User save(@RequestBody UserViewModel userViewModel, BindingResult bindingResult) throws ParseException {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		User user = this.mapper.convertToUserEntity(userViewModel);

	    this.userService.insertOrUpdate(user);

	    return user;
	}
	
	@GetMapping("/login/{email}/{password}")
	public Long getUser(@PathVariable String email, @PathVariable String password) {
		
		User user = this.userService.getByEmail(email);
		System.out.println(user);
		if (user != null && user.getPassword().equals(password)) {
			return user.getId();
		}
		
		return (long) 0;
		
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.userService.delete(id);
	}

}
