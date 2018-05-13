package com.mondp.entities.enums;

public enum NiveauFormation {

	
BAC("BAC"), BAC1("BAC + 1"), BAC2("BAC + 2"), BAC3("BAC + 3"), BAC4("BAC + 4"), BAC5("BAC + 5"), BAC5ETPLUS("BAC + 5 ou plus");
	
	private String valeur ;
	
	NiveauFormation(String niveau){
		valeur = niveau;
	}

	@Override
	public String toString() {
	return valeur;
	}
}
