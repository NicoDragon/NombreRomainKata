package org.kata.chiffresRomain.service.impl;

import org.kata.chiffresRomain.ChiffresParUnite;
/**
 * service de conversion des nombres arabes vers les nombres romains
 * @author MSI
 *
 */
public class ConversionNombreArabeVersNombreRomainService {
	
	/* passer en singletion et utiliser CDI de jee pour injecter */
	NombreService nombreService = new NombreService();

	/**
	 * service de conversion d'un nombre en nombre romain
	 * 
	 * @param nombre
	 *            
	 */
	public String convertirEnNombreRomainDepuisNombreArabe(final String nombre) throws Exception {
		String resultat = "";

		// le i va nous indiquer l'unité
		for (int index = 0; index < nombre.length(); index++) {
			String chiffre = nombreService.recupererChiffreDepuisNombre(nombre, index);
			int unite = nombreService.calculerUniteAPartirIndexIteration(nombre, index);

			// le second paramètre donne les dizaines/centaines/milliers
			resultat += convertirChiffreArabeEnChiffreRomain(chiffre, unite);
		}

		return resultat;
	}

	/**
	 * 
	 * @param chiffresRomainsServiceImpl
	 *            TODO
	 * @param chiffre
	 * @param unite
	 * @return
	 * @throws Exception
	 */
	private String convertirChiffreArabeEnChiffreRomain(final String chiffre, final int unite) throws Exception {
		String resultat = null;
		/* on appelle deux fois la methode mais je trouve cela plus explicite */
		String chiffreUniteRomain = ChiffresParUnite.recupererChiffreRomainDepuisUnite(unite).getUneUniteRomaine();
		String chiffreCinqUnitesRomain = ChiffresParUnite.recupererChiffreRomainDepuisUnite(unite)
				.getCinqUniteRomaine();
		resultat = convertirChiffreArabeEnChiffreRomainPourUniteDonnee(chiffre, unite, chiffreUniteRomain,
				chiffreCinqUnitesRomain);
		return resultat;
	}

	/**
	 * converti un chiffre en chiffre romain
	 * 
	 * @param chiffreArabe
	 * @param unite
	 *            indiquant dizaine,centaine,millier
	 * @param chiffreUniteRomain
	 *            chiffre romain pour une unite
	 * @param chiffreCinqUnitesRomain
	 *            chiffre romain pour cinq unites
	 * @return le chiffre en chiffre romain
	 * @throws Exception
	 */
	public String convertirChiffreArabeEnChiffreRomainPourUniteDonnee(final String chiffreArabe, final int unite,
			final String chiffreUniteRomain, String chiffreCinqUnitesRomain) throws Exception {
		String resultat = null;

		switch (chiffreArabe) {
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
			String chiffreUniteRomainSuperieur = ChiffresParUnite.recupererChiffreRomainDepuisUnite(unite + 1)
					.getUneUniteRomaine();
			resultat = chiffreUniteRomain + chiffreUniteRomainSuperieur;
			break;
		default:
			assert false : "erreur dans le parametre :" + chiffreArabe;
			break;
		}
		return resultat;
	}

}
