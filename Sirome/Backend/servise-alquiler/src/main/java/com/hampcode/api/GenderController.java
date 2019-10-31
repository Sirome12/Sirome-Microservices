package com.hampcode.api;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.model.Gender;
import com.hampcode.model.Review;
import com.hampcode.model.User;
import com.hampcode.api.viewmodel.GenderViewModel;
import com.hampcode.api.viewmodel.ReviewViewModel;
import com.hampcode.service.GenderService;


@RestController
@RequestMapping("/api/genders")
public class GenderController {

	@Autowired
	private GenderService genderService;
	
	@Autowired
	private Mapper mapper;

	
	@GetMapping
	public List<Gender> all() {
		List<Gender> genders = this.genderService.getAll();
		return genders;
	}
	

	@PostMapping
	public Gender save(@RequestBody GenderViewModel genderViewModel, BindingResult bindingResult) throws ParseException {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Gender gender = this.mapper.convertToGenderEntity(genderViewModel);

	    this.genderService.insertOrUpdate(gender);

	    return gender;
	}
	
	@GetMapping("/{id}")
	public Gender byId(@PathVariable Long id) {
		Optional<Gender> gender = this.genderService.getOne(id);

		if (!gender.isPresent()) {
			throw new EntityNotFoundException();
		}

		return gender.get();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.genderService.delete(id);
	}

}
