package com.mondp.controllers;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Utilisateur>> getUtilisateurs() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
		if (utilisateurs != null && !utilisateurs.isEmpty()) {
			return new ResponseEntity<>(utilisateurs, headers, OK);
		}
		return new ResponseEntity<>(headers, NOT_FOUND);
		
		
	}
	
	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable Long id) {
		Utilisateur u = utilisateurRepository.findOne(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		if (u != null) {
			return new ResponseEntity<>(u, headers, OK);
		}
		return new ResponseEntity<>(headers, NOT_FOUND);
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
												@RequestParam(name="size", defaultValue="10") int pageSize) {
		return utilisateurRepository.chercherUtilisateur("%"+stringKey+"%", new PageRequest(pageNumber, pageSize));
	}
	
	
//	@RequestMapping(value = "/chercherUtilisateurs", method = RequestMethod.GET)
//	public Page<Utilisateur> chercheUtilisateur(@RequestParam(name="mc", defaultValue="") String stringKey, 
//												@RequestParam(name="page", defaultValue="0") int pageNumber, 
//												@RequestParam(name="size", defaultValue="5") int pageSize) {
//		return utilisateurRepository.chercherUtilisateur("%"+stringKey+"%", PageRequest.of(pageNumber, pageSize));
//	}

}