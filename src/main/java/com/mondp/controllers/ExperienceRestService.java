package com.mondp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mondp.entities.Experience;
import com.mondp.repositories.ExperienceRepository;

@RestController
@CrossOrigin(origins="*")
public class ExperienceRestService {


	@Autowired
	ExperienceRepository experienceRepository;

	@RequestMapping(value = "/experiences", method = RequestMethod.GET)
	public List<Experience> getUtilisateurs() {
		return experienceRepository.findAll();
	}
	
	@RequestMapping(value = "/experiences/{idExperience}", method = RequestMethod.GET)
	public Experience getUtilisateur(@PathVariable Long idExperience) {
		return experienceRepository.findOne(idExperience);
	}
	
	@RequestMapping(value = "/experiences", method = RequestMethod.POST)
	public Experience saveUtilisateur(@RequestBody Experience experience) {
		return experienceRepository.save(experience);
	}
	
	@RequestMapping(value = "/formations/{idExperience}", method = RequestMethod.DELETE )
	public boolean deleteUtilisateur(@PathVariable Long idExperience) {
		experienceRepository.delete(idExperience);
		 return true;
	}
}
