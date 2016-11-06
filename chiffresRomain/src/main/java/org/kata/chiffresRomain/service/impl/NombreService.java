package org.kata.chiffresRomain.service.impl;

public class NombreService {

	/**
	 * calcule l'unité de grandeur à partir du nombre et de l'index
	 * 
	 * @param nombre
	 * @param index
	 * @return
	 */
	public int calculerUniteAPartirIndexIteration(String nombre, int index) {
		return nombre.length() - index - 1;
	}

	/**
	 * recupere un chiffre à partir d'un nombre
	 * 
	 * @param nombre
	 * @param indexChiffre
	 * @return
	 */
	public String recupererChiffreDepuisNombre(String nombre, int indexChiffre) {
		String chiffre = nombre.substring(indexChiffre, indexChiffre + 1);
		return chiffre;
	}

	/**
	 * verifie les parametres d'entree pour convert
	 * 
	 * @param nombre
	 * @throws Exception
	 */
	public void verifierNombreAvantConversionRomain(String nombre) throws Exception {
		int nombreConverti = Integer.valueOf(nombre);
		if (nombreConverti < 0 || nombreConverti > 5000) {
			throw new Exception("mauvais nombre pour la conversion");
		}
	}

}
