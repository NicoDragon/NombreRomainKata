package org.kata.chiffresRomain.service;
/**
 * classe de conversion des chiffres romains
 * @author MSI
 *
 */
public interface ChiffresRomainsService {

	/**
	 * conversion 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	String convertirNombreArabeVersNombreRomain(String nombre) throws Exception;
	
	String convertirNombreRomainVersNombreArabe(String nombreRomain);
}
