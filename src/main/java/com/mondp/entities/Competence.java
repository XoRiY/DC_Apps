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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mondp.entities.enums.NiveauCompetence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "COMPETENCES")
@Setter
@Getter
@ToString
public class Competence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5060724108649561374L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPTETENCE")
	private Long idCompetence;

	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR", nullable = false, unique = false, foreignKey = @ForeignKey(name = "FK_COMPETENCE_UTILISATEURS_ID_UTILISATEUR"))
	private Utilisateur utilisateur;

	@Column(name = "NIVEAU_COMPETENCE", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private NiveauCompetence nivCompetence;

}
