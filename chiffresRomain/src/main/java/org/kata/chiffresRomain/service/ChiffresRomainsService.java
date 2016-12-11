package org.kata.chiffresRomain.service;

import org.kata.chiffresRomain.exception.DonneesEntreesException;

/**
 * classe de conversion des chiffres romains
 * @author MSI
 *
 */
public interface ChiffresRomainsService {

	/**
	 * conversion des nombres arabes vers nombres romain
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	String convertirNombreArabeVersNombreRomain(String nombre) throws DonneesEntreesException;
	
}
