package org.kata.chiffresRomain;

public enum Chiffre {
	ZERO("0"), UN("1"), DEUX("2"), TROIS("3"), QUATRE("4"), CINQ("5"), SIX("6"), SEPT("7"), HUIT("8"), NEUF("9");

	private String valeur;

	Chiffre(String valeur) {
		this.valeur = valeur;
	}
}
