package com.mondp.entities;

import java.io.Serializable;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mondp.entities.enums.Pays;
import com.mondp.entities.enums.TypeVoie;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ADRESSES")
@Getter
@Setter
public class Adresse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9078013865582458915L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADRESSE")
	private Long idAdresse;

	@Column(name = "NUMERO_VOIE", nullable = false, length=5)
	@Min(1)
	@NotNull
	private Integer numeroVoie;

	@Column(name = "TYPE_DE_LA_VOIE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TypeVoie typeVoie;

	@Column(name = "NOM_VOIE", nullable = false, length = 120)
	@Size(min = 2, max = 120, message = "la taille doit être comprise entre {min} et  {max}")
	@NotNull
	private String nomVoie;

	@Column(name = "COMPLEMENT_ADRESSE")
	private String complementAdresse;

	@Column(name = "COMPLEMENT_ADRESSE2")
	private String complementAdresse2;

	@Column(name = "COMPLEMENT_ADRESSE3")
	private String complementAdresse3;

	@Column(name = "CODE_POSTAL", nullable = false, length=5)
	@NotNull
	private Integer codePostal;

	@Column(name = "VILLE", nullable = false, length = 45)
	@Size(min = 2, max = 30, message = "la taille doit être comprise entre {min} et  {max}")
	@NotNull
	private String ville;

	@Column(name = "PAYS", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Pays pays;
	
	@ManyToOne
	@JoinColumn(name="ID_UTILISATEUR", nullable = false, unique= false, foreignKey = @ForeignKey(name="FK_ADRESSES_UTILISATEURS_ID_UTILISATEUR"))
	private Utilisateur utilisateur;
	
}
