package com.sirome.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.sirome.model.entity.Movie;
import com.sirome.model.entity.User;
import com.sirome.controller.viewmodel.GenderViewModel;
import com.sirome.controller.viewmodel.MovieViewModel;
import com.sirome.controller.viewmodel.ReviewViewModel;
import com.sirome.controller.viewmodel.UserViewModel;
import com.sirome.model.entity.Gender;
import com.sirome.model.entity.Review;
import com.sirome.model.repository.MovieRepository;
import com.sirome.model.repository.GenderRepository;

@Component
public class Mapper {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenderRepository genderRepository;

	private Set<Gender> genders;
	
	public MovieViewModel convertToMovieViewModel(Movie entity) {
		MovieViewModel viewModel = new MovieViewModel();
		viewModel.setName(entity.getName());
		viewModel.setId(entity.getId());
		viewModel.setSinopsis(entity.getSinopsis());
		viewModel.setTrailer(entity.getTrailer());
		viewModel.setImdb_id(entity.getImdb_id());
		viewModel.setSlogan(entity.getSlogan());
		viewModel.setDuration(entity.getDuration());
		viewModel.setViews(entity.getViews());
		viewModel.setSource(entity.getSource());
		viewModel.setRental_price(entity.getRental_price());
		List<Long> genderIds = new ArrayList<Long>();
		entity.getGenders().stream().forEach(gender -> genderIds.add(gender.getId()));
		viewModel.setGenders(genderIds);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(entity.getRelease_date());
		viewModel.setRelease_date(date);
		viewModel.setBackdrop_url(entity.getBackdrop_url());
		viewModel.setPoster_url(entity.getPost_url());
		return viewModel;
	}
	
	public Movie convertToMovieEntity(MovieViewModel viewModel) throws ParseException {
		
		Set<Gender> genders = new HashSet<>();
		
		viewModel.getGendersIds().stream().forEach(genderId -> genders.add(this.genderRepository.findById(genderId).get()));
		
		Movie entity = new Movie(viewModel.getId(), viewModel.getName(), viewModel.getSlogan(), 
				viewModel.getTrailer(), viewModel.getImdb_id(), viewModel.getSinopsis(), viewModel.getDuration(),
				viewModel.getViews(), viewModel.getSource(), viewModel.getRental_price(), viewModel.getRelease_date(), viewModel.getPoster_url(), viewModel.getBackdrop_url(), genders);

		return entity;
	}
	
	public GenderViewModel converToGenderViewModel(Gender entity) {
		GenderViewModel viewModel = new GenderViewModel();
		viewModel.setId(entity.getId());
		viewModel.setName(entity.getName());
		return viewModel;
	}
	
	public Gender convertToGenderEntity(GenderViewModel viewModel) {
		Gender gender = new Gender(viewModel.getId(), viewModel.getName());
		return gender;
	}
	
	
}
