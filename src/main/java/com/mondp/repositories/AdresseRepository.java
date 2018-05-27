package com.mondp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mondp.entities.Adresse;
import com.mondp.entities.Utilisateur;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

	Adresse getAdressesByUtilisateur(Utilisateur utilisateur);

}
