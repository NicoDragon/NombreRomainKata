package org.kata.chiffresRomain.service.impl;

import org.kata.chiffresRomain.exception.DonneesEntreesException;

/**
 * service concernant les nombres
 * 
 * @author MSI
 *
 */
public class NombreService {

	/*  */
	private int LIMITE_NOM_SUPERIEUR = 5000;
	/*  */
	private int LIMITE_NOMBRE_INFERIEUR = 0;

	/**
	 * calcule l'unité de grandeur à partir du nombre et de l'index
	 * 
	 * @param nombre
	 * @param index
	 * @return unite à partir de 0
	 */
	public int calculerUniteAPartirIndexIteration(String nombre, int index) {
		return nombre.length() - index - 1;
	}

	/**
	 * recupere un chiffre à partir d'un nombre
	 * 
	 * @param nombre
	 * @param indexChiffreEnPartantdeLaGauche
	 * @return
	 */
	public String recupererChiffreDepuisNombre(String nombre, int indexChiffreEnPartantdeLaGauche) {
		String chiffre = nombre.substring(indexChiffreEnPartantdeLaGauche, indexChiffreEnPartantdeLaGauche + 1);
		return chiffre;
	}

	/**
	 * verifie les parametres d'entree pour convert
	 * 
	 * @param nombre
	 * @throws Exception
	 */
	public void verifierNombreAvantConversionRomain(String nombre) throws DonneesEntreesException {
		int nombreConverti = Integer.valueOf(nombre);
		if (aNombreValeurOkPourConversion(nombreConverti)) {
			throw new DonneesEntreesException("mauvais nombre pour la conversion");
		}
	}

	/**
	 * indique si la valeur du nombre est ok pour la conversion
	 * 
	 * @param nombreConverti
	 * @return
	 */
	private boolean aNombreValeurOkPourConversion(int nombreConverti) {
		return nombreConverti < LIMITE_NOMBRE_INFERIEUR || nombreConverti > LIMITE_NOM_SUPERIEUR;
	}

}
