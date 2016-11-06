package org.kata.chiffresRomain.service.impl;

import org.kata.chiffresRomain.exception.DonneesEntreesException;
import org.kata.chiffresRomain.service.NombresRomainsControlesService;

/**
 * controle sur les nombres romains
 * 
 * @author MSI
 */
public class NombresRomainsControlesServiceImpl implements NombresRomainsControlesService {

	public NombresRomainsControlesServiceImpl() {
	}

	/**
	 * controle le nombre avant d'être converti en nombre romain
	 * 
	 * @param nombre
	 * @throws DonneesEntreesException
	 */
	@Override
	public void controlerNombreAvantConversion(String nombre) throws DonneesEntreesException, NumberFormatException {
		int nombreDecimal = Integer.valueOf(nombre);

		if (!estNombreDecimalOkPourConversion(nombreDecimal)) {
			throw new DonneesEntreesException();
		}

	}

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	private boolean estNombreDecimalOkPourConversion(int nombre) {
		return nombre > 0 && nombre < 5000;
	}
}
