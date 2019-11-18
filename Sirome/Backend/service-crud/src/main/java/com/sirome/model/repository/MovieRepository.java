package com.sirome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sirome.model.entity.Gender;
import com.sirome.model.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findAllByGenders_Id(Long id);
}
