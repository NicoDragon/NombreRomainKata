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
public class ChiffresRomainsServiceTest {
	
	@Parameters(name=" nombre :{0}, resultat attendu :{1} ")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ "1", "I" },
			{ "101", "CI" },
			{ "156", "CLVI" },
			{ "169", "CLXIX" } ,
			{ "149", "CXLIX" } ,
			{ "4888", "MMMMDCCCLXXXVIII" }
		});
	}
	@Parameter 
	public String nombreEnEntree;
	
	@Parameter(value = 1)
	public  String nombreRomainAttendu;
	
	ChiffresRomainsService chiffresRomainsService = new ChiffresRomainsServiceImpl();
	
	
	@Test
	public void convertirEnChiffresRomainsDepuisNombreTU() throws Exception{
		
		//WHEN
		String resultat=chiffresRomainsService.convertirNombreArabeVersNombreRomain(nombreEnEntree);
		
		//THEN
		Assert.assertEquals("mauvaise conversion du chiffre 1",nombreRomainAttendu, resultat);

	}

}
