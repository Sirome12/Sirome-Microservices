package com.sirome.service;

import java.util.List;

import com.sirome.model.entity.Movie;

public interface MovieService extends CrudService<Movie> {
	List<Movie> findAllByGenders_Id(Long id);
}
