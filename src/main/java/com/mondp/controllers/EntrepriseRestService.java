package com.mondp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mondp.entities.Entreprise;
import com.mondp.repositories.EntrepriseRepository;

@RestController
@CrossOrigin(origins="*")
public class EntrepriseRestService {
	


	@Autowired
	EntrepriseRepository entrepriseRepository;

	@RequestMapping(value = "/entreprises", method = RequestMethod.GET)
	public List<Entreprise> getUtilisateurs() {
		return entrepriseRepository.findAll();
	}
	
	@RequestMapping(value = "/entreprises/{idEntreprise}", method = RequestMethod.GET)
	public Entreprise getUtilisateur(@PathVariable Long idEntreprise) {
		return entrepriseRepository.findOne(idEntreprise);
	}
	
	@RequestMapping(value = "/entreprises", method = RequestMethod.POST)
	public Entreprise saveUtilisateur(@RequestBody Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}
	
	@RequestMapping(value = "/entreprises/{idEntreprises}", method = RequestMethod.DELETE )
	public boolean deleteUtilisateur(@PathVariable Long idEntreprise) {
		entrepriseRepository.delete(idEntreprise);
		 return true;
	}

}
