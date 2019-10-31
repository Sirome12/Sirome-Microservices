package com.hampcode.service;

import java.util.List;

import com.hampcode.model.Movie;

public interface MovieService extends CrudService<Movie> {
	List<Movie> findAllByGenders_Id(Long id);
}
