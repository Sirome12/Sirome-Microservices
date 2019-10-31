package com.hampcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Movie;
import com.hampcode.model.User;
import com.hampcode.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findAllByUser(User user);
	List<Review> findAllByMovie(Movie movie);
}
