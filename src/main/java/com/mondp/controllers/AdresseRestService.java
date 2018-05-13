package com.mondp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mondp.entities.Adresse;
import com.mondp.repositories.AdresseRepository;

@RestController
@CrossOrigin(origins = "*")
public class AdresseRestService {

	@Autowired
	AdresseRepository adresseRepository;

	@RequestMapping(value = "/adresses", method = RequestMethod.GET)
	public List<Adresse> getUtilisateurs() {
		return adresseRepository.findAll();
	}

	@RequestMapping(value = "/adresses/{id}", method = RequestMethod.GET)
	public Adresse getUtilisateur(@PathVariable Long idAdresse) {
		return adresseRepository.findOne(idAdresse);
	}

	@RequestMapping(value = "/adresses", method = RequestMethod.POST)
	public Adresse saveUtilisateur(@RequestBody Adresse adresse) {
		return adresseRepository.save(adresse);
	}

	@RequestMapping(value = "/adresses/{idAdresse}", method = RequestMethod.PUT)
	public Adresse updateUtilisateur(@PathVariable Long idAdresse, @RequestBody Adresse adresse) {
		if (idAdresse != null && idAdresse > 0) {
			adresse.setIdAdresse(idAdresse);
			return adresseRepository.save(adresse);
		} else {
			throw new IllegalArgumentException("l'id doit etre superieur à 0 ");
		}
	}

	@RequestMapping(value = "/adresses/{id}", method = RequestMethod.DELETE)
	public boolean deleteUtilisateur(@PathVariable Long id) {
		adresseRepository.delete(id);
		return true;
	}
	
	
}
