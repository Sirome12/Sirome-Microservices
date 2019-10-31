package com.hampcode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	//List<Movie> findAllByGenders_Id(Long id);
}
