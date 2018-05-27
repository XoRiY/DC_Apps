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
import com.mondp.entities.enums.NiveauFormation;
import com.mondp.entities.enums.Pays;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="FORMATIONS")
@ToString(callSuper=false, exclude={"idFormation"})
public class Formation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 891083664874933354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FORMATION")
	private Long idFormation; 
	
	
	@Past
	@Column(name="DATE_DEBUT_FORMATION", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.ANY, pattern="yyyy-MM-dd", timezone="UTC+2")
	private Date dateDebut;
	
	@Column(name="DATE_FIN_FORMATION", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.ANY, pattern="yyyy-MM-dd", timezone="UTC+2")
	private Date dateFin;
	
	@Column(name="LIBELLE_FORMATION", nullable = false)
	@NotNull //@NotBlank
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String libelleFormation;
	
	@Column(name="ORGANISME", nullable = false)
	@NotNull //@NotBlank
	@Size(min = 1, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String organisme;
	
	@Column(name="NIVEAU_FORMATION", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private NiveauFormation niveauFomration;
	
	@Column(name="VILLE_ORGANISME_FORMATION", nullable = false)
	@NotNull //@NotBlank
	@Size(min = 1, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String ville;
	
	@Column(name = "PAYS")
	@Enumerated(EnumType.STRING)
	private Pays pays;
	
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR" , nullable = false, unique= false, foreignKey = @ForeignKey(name="FK_FORMATION_UTILISATEURS_ID_UTILISATEUR"))
	private Utilisateur utilisateur;
	
}
