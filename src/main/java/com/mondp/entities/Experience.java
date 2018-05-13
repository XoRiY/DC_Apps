package com.mondp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mondp.entities.enums.Pays;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="EXPERIENCES")
@Entity
@Getter
@Setter
@ToString(callSuper=false, of={"dateDebutExperience", "dateFinExperience", "libellePoste", "ville", "pays", "entreprise" })
public class Experience implements Serializable{
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = -358831556325121075L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPERIENCE")
	private Long idExperience; 
	
	@Past
	@Column(name="DATE_DEBUT_EXPERIENCE", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.ANY, pattern="yyyy-MM-dd", timezone="UTC+2")
	private Date dateDebutExperience;
	
	@Column(name="DATE_FIN_EXPERIENCE", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.ANY, pattern="yyyy-MM-dd", timezone="UTC+2")
	private Date dateFinExperience;
	
	@Column(name="LIBELLE_POSTE", nullable = false)
	@NotNull //@NotBlank
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et {max}")
	private String libellePoste;
	
	@Column(name="VILLE", nullable = false)
	@NotNull //@NotBlank
	@Size(min = 1, max = 50, message = "la taille doit être comprise entre {min} et {max}")
	private String ville;

	@Column(name = "PAYS")
	@Enumerated(EnumType.STRING)
	private Pays pays;

	@ManyToOne
	@JoinColumn(name="ID_ENTREPRISE" , unique= false, foreignKey = @ForeignKey(name="FK_EXPREIENCE_ENTREPRISE_ID_ENTREPRISE"))
	@JsonIgnoreProperties(value={"nomEntreprise", "villeEntreprise", "paysEntreprise"})
	@NotNull //@NotBlank
	private Entreprise entreprise;
	
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR" , nullable = false, unique= false, foreignKey = @ForeignKey(name="FK_EXPREIENCE_UTILISATEURS_ID_UTILISATEUR"))
	@JsonIgnoreProperties(value={"nom", "prenom", "dateInscription", "civilite", "emailUtilisateur", "dateNaissance", "telephone", "motDePasseUtilisateur"})
	private Utilisateur utilisateur;
	
}
//{idExpreienceProfessionnelle, dateDebutEXP, dateFinEXP }