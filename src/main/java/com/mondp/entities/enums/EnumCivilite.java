package com.mondp.entities.enums;

public enum EnumCivilite {
	

	
	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");
	
	private String valeur ;
	
	EnumCivilite(String etat){
		valeur = etat;
	}

	@Override
	public String toString() {
	return valeur;
	}
}