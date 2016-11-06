package org.kata.chiffresRomain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.kata.chiffresRomain.service.ChiffresRomainsService;
import org.kata.chiffresRomain.service.impl.ChiffresRomainsServiceImpl;

@RunWith(Parameterized.class)
public class ChiffresRomainsServiceTest2 {
	
	@Parameters(name=" chiffre romain :{0}, nombre attendu :{1} ")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ "I", "1" },
			{ "II","2"},
			{ "C","100"},
			{ "MM","2000"},
			{ "XII","12"},
			{"XCIX","99"}
			
		});
	}
	@Parameter 
	public String nombreRomainEnEntree;
	
	@Parameter(value = 1)
	public  String nombreArabe;
	
	ChiffresRomainsService chiffresRomainsService = new ChiffresRomainsServiceImpl();
	
	
	@Test
	public void convertirEnChiffresRomainsDepuisNombreTU() throws Exception{
		
		//WHEN
		String resultat=chiffresRomainsService.convertirNombreRomainVersNombreArabe(nombreRomainEnEntree);
		
		//THEN
		Assert.assertEquals("mauvaise conversion du chiffre 1",nombreArabe, resultat);

	}

}
