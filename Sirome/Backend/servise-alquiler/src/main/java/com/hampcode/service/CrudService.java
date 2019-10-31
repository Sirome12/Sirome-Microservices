package com.hampcode.service;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.Gender;
import com.hampcode.model.User;

public interface CrudService<T> {

	T insertOrUpdate(T entity);

	Optional<T> getOne(Long id);

	List<T> getAll();

	void delete(Long id);

}
