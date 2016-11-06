package org.kata.chiffresRomain.service;

import org.kata.chiffresRomain.exception.DonneesEntreesException;

/**
 * classe gérant les contrôles sur les nombres
 * @author MSI
 *
 */
public interface NombresRomainsControlesService {

	/**
	 * controle les nombres avant leur conversion
	 * @param nombre
	 * @throws DonneesEntreesException
	 * 
	 */
	void controlerNombreAvantConversion(String nombre) throws DonneesEntreesException,NumberFormatException;

	
}
