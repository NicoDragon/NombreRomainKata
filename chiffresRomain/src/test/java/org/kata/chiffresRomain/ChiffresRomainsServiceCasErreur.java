package org.kata.chiffresRomain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.kata.chiffresRomain.service.ChiffresRomainsService;
import org.kata.chiffresRomain.service.impl.ChiffresRomainsServiceImpl;

@RunWith(Parameterized.class)
public class ChiffresRomainsServiceCasErreur {
	@Parameters
	public static List<String> data() {
		return Arrays.asList(new String[]  { 
			 "-1", "-5000" , "56800" });
	}
	@Parameter 
	public String nombreEnEntree;
	
	
	ChiffresRomainsService chiffresRomainsService = new ChiffresRomainsServiceImpl();
	/**
	 * on verfie les cas d'erreur 
	 */
	@Test(expected=Exception.class)
	public void convertirEnChiffresRomainsDepuisNombreTU() throws Exception{
		
		//WHEN
		String resultat=chiffresRomainsService.convertirNombreArabeVersNombreRomain(nombreEnEntree);
		

	}

}
