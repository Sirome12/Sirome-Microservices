package com.hampcode.api;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.model.Movie;
import com.hampcode.model.Review;
import com.hampcode.api.viewmodel.MovieViewModel;
import com.hampcode.api.viewmodel.ReviewViewModel;
import com.hampcode.service.MovieService;


@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private Mapper mapper;

	
	@GetMapping
	public List<Movie> all() {
		List<Movie> movies = this.movieService.getAll();
		return movies;
	}
	

	@PostMapping
	public Movie save(@RequestBody MovieViewModel movieViewModel, BindingResult bindingResult) throws ParseException {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Movie movie = this.mapper.convertToMovieEntity(movieViewModel);

	    this.movieService.insertOrUpdate(movie);

	    return movie;
	}
	
	@GetMapping("/byGenderId/{gender_id}")
	public List<Movie> getMoviesByGenderId(@PathVariable Long gender_id) {
		
		List<Movie> movies = this.movieService.findAllByGenders_Id(gender_id);
		
		if (movies.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		return movies;
		
	}
	
	
	@GetMapping("/{id}")
	public Movie byId(@PathVariable Long id) {
		Optional<Movie> movie = this.movieService.getOne(id);

		if (!movie.isPresent()) {
			throw new EntityNotFoundException();
		}

		return movie.get();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.movieService.delete(id);
	}

}
