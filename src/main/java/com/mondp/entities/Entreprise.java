package com.mondp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mondp.entities.enums.Pays;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper=false, of={"nomEntreprise", "villeEntreprise", "paysEntreprise"})
@Entity
@Table(name="ENTREPRISES", uniqueConstraints =  @UniqueConstraint(columnNames={"NOM_ENTREPRISE", "VILLE_ENTREPRISE", "PAYS_ENTREPRISE"}, name="UK_NOM_VILLE_PAYS"))
public class Entreprise implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5260761816811161088L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENTREPRISE", insertable = false)
	private Long idEntreprise; 
	
	@Column(name = "NOM_ENTREPRISE", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String nomEntreprise;
	
	@Column(name = "VILLE_ENTREPRISE", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	private String villeEntreprise;
	
	@Column(name = "PAYS_ENTREPRISE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Pays paysEntreprise;
	
}
