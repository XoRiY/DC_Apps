package com.mondp.entities.enums;

public enum NiveauCompetence {
	
	NOTIONS(1,"*"), DEBUTANT(2, "**"), INTERMIDIAIRE(3, "***"), MAITRISE(4,"****"), EXPERT(5,"*****");
	
	private String valeurString ;
	
	private int valeurInt;
	
	NiveauCompetence(int i , String s){
		valeurString = s;
		valeurInt = i;
	}

	@Override
	public String toString() {
	return valeurString;
	}
	
	public int getValeurInt() {
		return valeurInt;
	}
	
	public String getValeurString() {
		return valeurString;
	}

}
