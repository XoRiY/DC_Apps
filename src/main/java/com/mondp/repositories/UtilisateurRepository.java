package com.mondp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mondp.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	@Query("select u from Utilisateur u where u.nom like :x")
	public Page<Utilisateur> chercherUtilisateur(@Param("x") String nomUtilisateur, Pageable pageable);
	
	
	
	
}
