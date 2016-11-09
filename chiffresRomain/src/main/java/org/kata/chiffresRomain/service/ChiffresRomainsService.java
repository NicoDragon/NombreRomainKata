package org.kata.chiffresRomain.service;
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
	String convertirNombreArabeVersNombreRomain(String nombre) throws Exception;
	
}
