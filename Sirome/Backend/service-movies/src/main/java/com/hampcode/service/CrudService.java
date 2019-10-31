package com.hampcode.service;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.entity.Movie;

public interface CrudService<T,ID> {
	T insertOrUpdate(T entity);

	Optional<T> getOne(Long id);

	List<T> getAll();

	void deleteById(Long id);

	Movie create(Movie entity);

}
