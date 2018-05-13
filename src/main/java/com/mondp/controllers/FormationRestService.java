package com.mondp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mondp.entities.Formation;
import com.mondp.repositories.FormationRepository;

@RestController
@CrossOrigin(origins="*")
public class FormationRestService {



	@Autowired
	FormationRepository formationRepository;

	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public List<Formation> getUtilisateurs() {
		return formationRepository.findAll();
	}
	
	@RequestMapping(value = "/formations/{id}", method = RequestMethod.GET)
	public Formation getUtilisateur(@PathVariable Long idFormation) {
		return formationRepository.findOne(idFormation);
	}
	
	@RequestMapping(value = "/formations", method = RequestMethod.POST)
	public Formation saveUtilisateur(@RequestBody Formation formation) {
		return formationRepository.save(formation);
	}
	
	@RequestMapping(value = "/formations/{idFpormation}", method = RequestMethod.DELETE )
	public boolean deleteUtilisateur(@PathVariable Long idFormation) {
		formationRepository.delete(idFormation);
		 return true;
	}
}
