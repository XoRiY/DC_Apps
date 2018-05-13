package com.mondp;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mondp.controllers.AdresseRestService;
import com.mondp.entities.Adresse;
import com.mondp.entities.Entreprise;
import com.mondp.entities.Experience;
import com.mondp.entities.Formation;
import com.mondp.entities.Utilisateur;
import static com.mondp.entities.enums.EnumCivilite.*;
import static com.mondp.entities.enums.NiveauFormation.*;
import static com.mondp.entities.enums.Pays.*;
import static com.mondp.entities.enums.TypeVoie.*;
import com.mondp.repositories.AdresseRepository;
import com.mondp.repositories.EntrepriseRepository;
import com.mondp.repositories.ExperienceRepository;
import com.mondp.repositories.FormationRepository;
import com.mondp.repositories.UtilisateurRepository;

import lombok.extern.java.Log;

@SpringBootApplication
public class MondpApplication implements CommandLineRunner {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	FormationRepository formationRepository;

	@Autowired
	EntrepriseRepository entrepriseRepository;

	@Autowired
	ExperienceRepository experienceRepository;

	@Autowired
	AdresseRepository adresseRepository;

	public static void main(String[] args) {
		SpringApplication.run(MondpApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		try {
			int aleatoire;
			int aleatoire2;

			for (int i = 0; i < 2; i++) {

				aleatoire = ((int) (Math.random() * 1000));
				aleatoire2 = ((int) (Math.random() * 1000));

				String nom = "KERDOUD" + aleatoire;
				String prenom = "tahar" + aleatoire2;
				String email = nom + prenom + "@gmail.com";
				String password = prenom + nom;
				String telephone = "0" + aleatoire + "" + aleatoire2 + "0";

				
				/*--------------- Utilisateur ---------------*/

				Calendar c = Calendar.getInstance();
				c.set(2000, 10, 12);
				Utilisateur utilisateur = new Utilisateur();

				utilisateur.setCivilite(M);
				utilisateur.setEmailUtilisateur(email);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setTelephone(telephone);
				utilisateur.setMotDePasseUtilisateur(password);
				utilisateur.setDateInscription(Calendar.getInstance().getTime());
				utilisateur.setDateNaissance(new Date("1987/11/27"));
				utilisateurRepository.save(utilisateur);

				
				/*--------------- Adresse ---------------*/

				Adresse adresse = new Adresse();
				adresse.setCodePostal(33700);
				adresse.setNomVoie("rue Brantome");
				adresse.setNumeroVoie(16);
				adresse.setVille("Merignac");
				adresse.setPays(FRANCE);
				adresse.setTypeVoie(ABBAYE);
				adresse.setUtilisateur(utilisateur);
				adresseRepository.save(adresse);

				for (int j = 0; j < 1; j++) {

					
					/*--------------- Formation ---------------*/

					Formation f = new Formation();
					f.setDateDebut(new Date("2010/01/01"));
					f.setDateFin(new Date("2012/01/01"));
					f.setLibelleFormation("BTS");
					f.setNiveauFomration(BAC2);
					f.setOrganisme("UNIVERSITE");
					f.setPays(FRANCE);
					f.setVille("bordeaux");
					f.setUtilisateur(utilisateur);
					formationRepository.save(f);

					
					/*--------------- Entreprise ---------------*/
					
					Entreprise ent = new Entreprise();
					ent.setNomEntreprise("Ausy"+aleatoire);
					ent.setPaysEntreprise(FRANCE);
					ent.setVilleEntreprise("Bordeaux");
					entrepriseRepository.save(ent);
					
					
					/*--------------- Experience ---------------*/

					Experience exp = new Experience();
					exp.setDateDebutExperience(new Date("2012/01/01"));
					exp.setDateFinExperience(new Date("2012/01/01"));
					exp.setLibellePoste("Ingénieur etude et développement");
					exp.setPays(FRANCE);
					exp.setVille("Bordeaux");
					exp.setEntreprise(ent);
					exp.setUtilisateur(utilisateur);
					experienceRepository.save(exp);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
