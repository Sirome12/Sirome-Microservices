package com.hampcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hampcode.api.viewmodel.GenderViewModel;
import com.hampcode.api.viewmodel.MovieViewModel;
import com.hampcode.api.viewmodel.ReviewViewModel;
import com.hampcode.api.viewmodel.UserViewModel;
import com.hampcode.model.Gender;
import com.hampcode.model.Movie;
import com.hampcode.model.Review;
import com.hampcode.model.User;
import com.hampcode.repository.GenderRepository;
import com.hampcode.repository.MovieRepository;
import com.hampcode.repository.ReviewRepository;
import com.hampcode.repository.UserRepository;

@Component
public class Mapper {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
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
	
	public UserViewModel convertToUserViewModel(User entity) {
		UserViewModel viewModel = new UserViewModel();
		viewModel.setId(entity.getId());
		viewModel.setName(entity.getName());
		viewModel.setLastname(entity.getLastname());
		viewModel.setBirthday(entity.getBirthday());
		viewModel.setPassword(entity.getPassword());
		viewModel.setEmail(entity.getEmail());
		viewModel.setProfile_img_url(entity.getProfile_img_url());
		return viewModel;
	}
	
	public User convertToUserEntity(UserViewModel viewModel) {
		User user = new User(viewModel.getId(), viewModel.getName(), viewModel.getLastname(), viewModel.getBirthday(), viewModel.getPassword(), viewModel.getEmail(), viewModel.getProfile_img_url());
		return user;
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
	
	public ReviewViewModel convertToReviewViewModel(Review entity) {
		
		ReviewViewModel ViewModel = new ReviewViewModel();
		
		ViewModel.setId(entity.getId());
		ViewModel.setTitle(entity.getTitle());
		ViewModel.setSummary(entity.getSummary());
		ViewModel.setWebsite(entity.getWebsite());
		ViewModel.setScore(entity.getScore());
		ViewModel.setContent(entity.getContent());
		ViewModel.setLastModifiedOn(entity.getLastModifiedOn());
		ViewModel.setMovieId(entity.getMovie().getId());
		ViewModel.setUserId(entity.getUser().getId());
		
		return ViewModel;

	}
	
	public Review converToReviewEntity(ReviewViewModel ViewModel) {
		Movie movie = this.movieRepository.findById(ViewModel.getMovieId()).get();
		User user = this.userRepository.findById(ViewModel.getUserId()).get();
		
		Review entity = new Review(ViewModel.getId(), ViewModel.getTitle(), ViewModel.getSummary(), 
				ViewModel.getWebsite(), ViewModel.getScore(), ViewModel.getContent(), 
				movie, user);
		
		return entity;
	}
	
}
