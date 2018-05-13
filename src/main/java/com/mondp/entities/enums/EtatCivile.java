package com.mondp.entities.enums;

public enum EtatCivile {
	
MARIE("Monsieur"), MADAME("Madame"), MADEMOISELLE("Mademoiselle");
	
	private String valeur ;
	EtatCivile(String etat){
		valeur = etat;
	}

	@Override
	public String toString() {
	return valeur;
	}
}