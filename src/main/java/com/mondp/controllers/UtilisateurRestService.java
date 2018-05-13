package com.mondp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mondp.entities.Utilisateur;
import com.mondp.repositories.UtilisateurRepository;

@RestController
@CrossOrigin(origins="*")
public class UtilisateurRestService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurRepository.findAll();
	}
	
	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.GET)
	public Optional<Utilisateur> getUtilisateur(@PathVariable Long id) {
		return Optional.of(utilisateurRepository.findOne(id));
	}
	
	@RequestMapping(value = "/utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		System.out.println(utilisateur.toString());
		return utilisateurRepository.save(utilisateur);
	}
	
	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.DELETE )
	public boolean deleteUtilisateur(@PathVariable Long id) {
		 utilisateurRepository.delete(id);
		 return true;
	}
	
	
	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
		utilisateur.setIdUtilisateur(id);
		return utilisateurRepository.save(utilisateur);
	}
	
	
	@RequestMapping(value = "/chercherUtilisateurs", method = RequestMethod.GET)
	public Page<Utilisateur> chercherUtilisateur(@RequestParam(name="mc", defaultValue="") String stringKey, 
												@RequestParam(name="page", defaultValue="0") int pageNumber, 
												@RequestParam(name="size", defaultValue="5") int pageSize) {
		return utilisateurRepository.chercherUtilisateur("%"+stringKey+"%", new PageRequest(pageNumber, pageSize));
	}
	
	
//	@RequestMapping(value = "/chercherUtilisateurs", method = RequestMethod.GET)
//	public Page<Utilisateur> chercheUtilisateur(@RequestParam(name="mc", defaultValue="") String stringKey, 
//												@RequestParam(name="page", defaultValue="0") int pageNumber, 
//												@RequestParam(name="size", defaultValue="5") int pageSize) {
//		return utilisateurRepository.chercherUtilisateur("%"+stringKey+"%", PageRequest.of(pageNumber, pageSize));
//	}
	
}