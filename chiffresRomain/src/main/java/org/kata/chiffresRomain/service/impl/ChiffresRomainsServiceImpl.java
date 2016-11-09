package org.kata.chiffresRomain.service.impl;

import org.kata.chiffresRomain.service.ChiffresRomainsService;

/**
 * 
 * @author MSI
 *
 */
public class ChiffresRomainsServiceImpl implements ChiffresRomainsService {

	/* service de conversion de nombre arabe vers nombres romains */
	ConversionNombreArabeVersNombreRomainService conversionNombreArabeVersNombreRomainsService = new ConversionNombreArabeVersNombreRomainService();

	NombreService nombreService = new NombreService();

	public ChiffresRomainsServiceImpl() {

	}

	/**
	 * service de conversion d'un nombre arabe en nombre romain
	 * 
	 * 
	 */
	public String convertirNombreArabeVersNombreRomain(String nombre) throws Exception {
		// todo checker entree
		nombreService.verifierNombreAvantConversionRomain(nombre);
		return conversionNombreArabeVersNombreRomainsService.convertirEnNombreRomainDepuisNombreArabe(nombre);
	}

}
