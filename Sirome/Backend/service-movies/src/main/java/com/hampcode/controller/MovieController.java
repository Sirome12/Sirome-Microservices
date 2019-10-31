package com.hampcode.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.model.entity.Movie;
import com.hampcode.exception.ResourceNotFoundException;
import com.hampcode.service.MovieService;


@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private Environment env;

	
	@GetMapping
	public ResponseEntity<List<Movie>> getProducts() {
		List<Movie> movies = movieService.getAll().stream().map(product -> {
			product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return product;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getProductById(@PathVariable Long id) {
		 Optional<Movie> product = movieService.getOne(id);
		    product.get().setPort(Integer.parseInt(env.getProperty("local.server.port")));
	        if (!product.isPresent()) {
	           new ResourceNotFoundException("Id " + id + " is not existed");
	        }

	        return ResponseEntity.ok(product.get());
	}
	
	@PostMapping
	public ResponseEntity<Movie> createProduct(@RequestBody Movie movie) {
		movieService.create(movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Movie> updateProduct(@PathVariable Long id,  @RequestBody Movie movie) {
        if (!movieService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Movie not found with id " + id);
        }

        return ResponseEntity.ok(movieService.create(movie));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		return movieService.getOne(id).map(product -> {
			movieService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));

	}

}
