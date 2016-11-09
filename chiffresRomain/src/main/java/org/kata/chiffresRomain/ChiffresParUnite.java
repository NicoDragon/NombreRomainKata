package org.kata.chiffresRomain;

import org.junit.Assert;

/**
 * 
 * ensemble des chiffres romains pour une unité donnée
 */
public enum ChiffresParUnite {
	/*  */
	UNITE("I", "V", "1", "5"), 
	/* dizaine */
	DIZAINE("X", "L", "10", "50"), CENTAINE("C", "D", "100", "500"), MILLIER("M", "M",
			"1000", "1000");

	/**
	 * chiffre romain pour une unité
	 */
	String uneUniteRomaine;
	/**
	 * chiffre romain pour cinq unités
	 */
	String cinqUniteRomaine;

	/* chiffre arabe pour une unité */
	String uneUniteChiffreArabe;

	/* chiffre arabe pour cinq unité */
	String cinqUniteChiffreArabe;

	ChiffresParUnite(String uneUniteRomaine, String cinqUniteRomaine, String uneUniteChiffreArable,
			String cinqUniteChiffreArabe) {
		this.uneUniteRomaine = uneUniteRomaine;
		this.cinqUniteRomaine = cinqUniteRomaine;
		this.uneUniteChiffreArabe = uneUniteChiffreArable;
		this.cinqUniteChiffreArabe = cinqUniteChiffreArabe;
	}

	/**
	 * recupere à partir d'un chiffre romain l'unité de ce dernier
	 * 
	 * @param chiffreRomain
	 * @return
	 */
	public static ChiffresParUnite recupererUniteAPartirChiffreRomain(final String chiffreRomain) {

		for (ChiffresParUnite unite : ChiffresParUnite.values()) {
			if (unite.getUneUniteRomaine().equalsIgnoreCase(chiffreRomain)
					|| unite.getCinqUniteRomaine().equalsIgnoreCase(chiffreRomain)) {
				return unite;
			}
		}

		Assert.fail("pas possible d'avoir aucun résultat" + chiffreRomain);
		return null;

	}
	/**
	 * permet de recuperer le chiffre arabe associé à ce chiffre romain pour cette unité
	 * @param chiffreRomain
	 * @return
	 */
	public int recupererChiffreArabeAssocie(final String chiffreRomain){
		if(uneUniteRomaine.equalsIgnoreCase(chiffreRomain)){
			return Integer.valueOf(uneUniteChiffreArabe);
		}else{
			return Integer.valueOf(cinqUniteChiffreArabe);
		}
	}
	public String getUneUniteRomaine() {
		return uneUniteRomaine;
	}


	public String getCinqUniteRomaine() {
		return cinqUniteRomaine;
	}


	public String getUneUniteChiffreArabe() {
		return uneUniteChiffreArabe;
	}


	public String getCinqUniteChiffreArabe() {
		return cinqUniteChiffreArabe;
	}

	/**
	 * recupere le chiffre romain depuis l'unité (dizaine,centaine etc...)
	 * 
	 * @param unite
	 * @return chiffre romain ou throw exception si pas trouvée
	 * @throws Exception
	 */
	public static ChiffresParUnite recupererChiffreRomainDepuisUnite(final int unite) throws Exception {
		// se base sur l'ordre de declaration de l'enum !
		return ChiffresParUnite.values()[unite];
	}
}
