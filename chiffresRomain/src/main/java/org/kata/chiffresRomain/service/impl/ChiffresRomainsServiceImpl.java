package org.kata.chiffresRomain.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.kata.chiffresRomain.ChiffresParUnite;
import org.kata.chiffresRomain.service.ChiffresRomainsService;

/**
 * 
 * @author MSI
 *
 */
public class ChiffresRomainsServiceImpl implements ChiffresRomainsService {

	ConversionNombreArabeVersNombreRomainService conversionNombreArabeVersNombreRomainsService=new ConversionNombreArabeVersNombreRomainService();
	
	NombreService nombreService=new NombreService();
	public ChiffresRomainsServiceImpl() {

	}

	/**
	 * convertit un nombre romain en nombre base dix <br>
	 * 1. recuperation première unité
	 * 
	 * @param nombreRomain
	 *            :
	 */
	public String convertirNombreRomainVersNombreArabe(final String nombreRomain) {
		int resultat=0;
		// on recupere l'asso des unites et des chiffres romains
		Map<ChiffresParUnite, String> assosChiffesRomainsUnites = recupererNombreRomainParUnite(nombreRomain);

		// ensuite on convertit en un et cinq
		Set<ChiffresParUnite> clefs = assosChiffesRomainsUnites.keySet();

		for (ChiffresParUnite clef : clefs) {
			String chiffresRomainsPourCetteUnite = assosChiffesRomainsUnites.get(clef);
			//todo convertir en chiffre
			for (int i = 0; i < chiffresRomainsPourCetteUnite.length(); i++) {
				char chiffreRomain=chiffresRomainsPourCetteUnite.charAt(i);
				
				//TODO gérer ordre ! si avant unité plus grande on soustrait
				resultat+=clef.recupererChiffreArabeAssocie(String.valueOf(chiffreRomain));
			}
		}

		// l'ordre détermine la somme pour cette unité
		return String.valueOf(resultat);
	}

	private Map<ChiffresParUnite, String> recupererNombreRomainParUnite(final String nombreRomain) {
		Map<ChiffresParUnite, String> assoUniteNombreRomain = new HashMap<ChiffresParUnite, String>();

		for (int i = 0; i < nombreRomain.length(); i++) {
			ajouterChiffreRomainATableDAsso(assoUniteNombreRomain, String.valueOf(nombreRomain.charAt(i)));
		}

		return assoUniteNombreRomain;
	}

	private void ajouterChiffreRomainATableDAsso(Map<ChiffresParUnite, String> associationsUniteNombreRomain,
			String caractere) {
		ChiffresParUnite unite = ChiffresParUnite
				.recupererUniteAPartirChiffreRomain(String.valueOf(caractere));
		
		if (associationsUniteNombreRomain.get(unite) == null) {
			associationsUniteNombreRomain.put(unite, "");
		}
		String chiffresRomainPourCetteUnite = associationsUniteNombreRomain.get(unite);
		chiffresRomainPourCetteUnite += caractere;
		associationsUniteNombreRomain.put(unite,chiffresRomainPourCetteUnite);
	}

	/**
	 * service de conversion d'un nombre en nombre romain
	 * @deprecated Use {@link org.kata.chiffresRomain.service.impl.ConversionNombreArabeVersNombreRomainService#convertirEnNombreRomainDepuisNombreArabe(org.kata.chiffresRomain.service.impl.ChiffresRomainsServiceImpl,String)} instead
	 * 
	 */
	public String convertirNombreArabeVersNombreRomain(String nombre) throws Exception {
		return conversionNombreArabeVersNombreRomainsService.convertirEnNombreRomainDepuisNombreArabe(this, nombre);
	}

	/**
	 * recupere le chiffre romain depuis l'unité (dizaine,centaine etc...)
	 * 
	 * @param unite
	 * @return chiffre romain ou throw exception si pas trouvée
	 * @throws Exception
	 */
	ChiffresParUnite recupererChiffreRomainDepuisUnite(final int unite) throws Exception {
		// se base sur l'ordre de declaration de l'enum !
		return ChiffresParUnite.values()[unite];

	}

}
