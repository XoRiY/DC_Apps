package com.mondp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mondp.entities.enums.EnumCivilite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity()
@Table(name="UTILISATEURS")
@Getter
@Setter
@ToString(callSuper=false, of={"nom", "prenom", "dateInscription", "civilite", 
		"emailUtilisateur", "dateNaissance", "telephone", "motDePasseUtilisateur"  })
public class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5786839425841430962L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTILISATEUR")
	private Long idUtilisateur;
	
	@Column(name = "NOM_UTILISATEUR", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String nom;

	@Column(name = "PRENOM_UTILISATEUR", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String prenom;

	@Column(name="LIBELLE_CIVILITE", length=10)
	@Enumerated(EnumType.STRING)
	@NotNull
	private EnumCivilite civilite;
	
	@Column(name = "DATE_INSCRIPTION")
	@JsonFormat(shape=JsonFormat.Shape.ANY, pattern="yyyy-MM-dd", timezone="UTC+2")
	@Temporal(value = TemporalType.DATE)
	private Date dateInscription = new Date();
	
	@Column(name = "DATE_NAISSANCE")
	@Past
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC+2")
	@Temporal(value = TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name = "EMAIL_UTILISATEUR", nullable = false, unique = true)
	//@Email
	@NotNull
	@Size(min = 6, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String emailUtilisateur;
	
	@Column(name = "TELEPHONE_UTILISATEUR", nullable = true)
	@Size(min = 1, max = 16, message = "la taille du champ 'Telephone' doit être comprise entre {min} et  {max}")
	@NotNull
	private String telephone;
	
	
	@Column(name = "MOT_DE_PASSE", nullable = false)
	@NotNull
	@Size(min = 4, max = 25, message = "la taille doit être comprise entre {min} et  {max}")
	private String motDePasseUtilisateur;
		
}

/*
<dependency>
<artifactId>hibernate-jpamodelgen</artifactId>
<groupId>hibernate-jpamodelgen</groupId>
<version>5.0.12.Final</version>
</dependency>*/