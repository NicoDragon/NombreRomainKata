package org.kata.chiffresRomain.service.impl;

public class ConversionNombreArabeVersNombreRomainService {

	/**
	 * service de conversion d'un nombre en nombre romain
	 * @param chiffresRomainsServiceImpl TODO
	 * @param nombre TODO
	 * 
	 */
	public String convertirEnNombreRomainDepuisNombreArabe(ChiffresRomainsServiceImpl chiffresRomainsServiceImpl, String nombre) throws Exception {
		// todo checker entree
		chiffresRomainsServiceImpl.nombreService.verifierNombreAvantConversionRomain(nombre);
	
		String resultat = "";
	
		// le i va nous indiquer l'unité
		for (int i = 0; i < nombre.length(); i++) {
			int index = i;
			String chiffre = chiffresRomainsServiceImpl.nombreService.recupererChiffreDepuisNombre(nombre, index);
	
			int unite = chiffresRomainsServiceImpl.nombreService.calculerUniteAPartirIndexIteration(nombre, index);
	
			// le second paramètre donne les dizaines/centaines/milliers
			resultat += convertirChiffreEnChiffreRomain(chiffresRomainsServiceImpl, chiffre, unite);
		}
	
		return resultat;
	}

	/**
	 * 
	 * @param chiffresRomainsServiceImpl TODO
	 * @param chiffre
	 * @param unite
	 * @return
	 * @throws Exception
	 */
	private String convertirChiffreEnChiffreRomain(ChiffresRomainsServiceImpl chiffresRomainsServiceImpl, String chiffre, int unite) throws Exception {
		String resultat = null;
		String chiffreUniteRomain = chiffresRomainsServiceImpl.recupererChiffreRomainDepuisUnite(unite).getUneUniteRomaine();
		String chiffreCinqUnitesRomain = chiffresRomainsServiceImpl.recupererChiffreRomainDepuisUnite(unite).getCinqUniteRomaine();
		resultat = chiffresRomainsServiceImpl.conversionNombreArabeVersNombreRomainsService.convertirChiffreArabeEnChiffreRomainPourUniteDonnees(chiffresRomainsServiceImpl, chiffre, unite, chiffreUniteRomain, chiffreCinqUnitesRomain);
		return resultat;
	}

	/**
	 * converti un chiffre en chiffre romain
	 * 
	 * @param chiffresRomainsServiceImpl TODO
	 * @param chiffre
	 * @param unite
	 *            indiquant dizaine,centaine,millier
	 * @param chiffreUniteRomain
	 *            chiffre romain pour une unite
	 * @param chiffreCinqUnitesRomain
	 *            chiffre romain pour cinq unites
	 * @return le chiffre en chiffre romain
	 * @throws Exception
	 */
	String convertirChiffreArabeEnChiffreRomainPourUniteDonnees(ChiffresRomainsServiceImpl chiffresRomainsServiceImpl, String chiffre, int unite, String chiffreUniteRomain, String chiffreCinqUnitesRomain) throws Exception {
		String resultat = null;
	
		switch (chiffre) {
		case "0":
			resultat = "";
			break;
		case "1":
			resultat = chiffreUniteRomain;
			break;
		case "2":
			resultat = chiffreUniteRomain + chiffreUniteRomain;
			break;
		case "3":
			resultat = chiffreUniteRomain + chiffreUniteRomain + chiffreUniteRomain;
			break;
		case "4":
			// exception pour les milliers
			if (unite == 3) {
				resultat = chiffreUniteRomain + chiffreUniteRomain + chiffreUniteRomain + chiffreUniteRomain;
			} else {
				resultat = chiffreUniteRomain + chiffreCinqUnitesRomain;
			}
			break;
		case "5":
			resultat = chiffreCinqUnitesRomain;
			break;
		case "6":
			resultat = chiffreCinqUnitesRomain + chiffreUniteRomain;
			break;
		case "7":
			resultat = chiffreCinqUnitesRomain + chiffreUniteRomain + chiffreUniteRomain;
			break;
		case "8":
			resultat = chiffreCinqUnitesRomain + chiffreUniteRomain + chiffreUniteRomain + chiffreUniteRomain;
			break;
		case "9":
			String chiffreUniteRomainSuperieur = chiffresRomainsServiceImpl.recupererChiffreRomainDepuisUnite(unite + 1).getUneUniteRomaine();
			resultat = chiffreUniteRomain + chiffreUniteRomainSuperieur;
			break;
		default:
			break;
		}
		return resultat;
	}

}
