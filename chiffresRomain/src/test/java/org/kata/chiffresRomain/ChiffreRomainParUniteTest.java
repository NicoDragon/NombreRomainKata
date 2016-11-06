package org.kata.chiffresRomain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ChiffreRomainParUniteTest {

	@Parameters(name=" nombre :{0}, resultat attendu :{1} ")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"I",ChiffresParUnite.UNITE },
			{  "V",ChiffresParUnite.UNITE },
			{ "C",ChiffresParUnite.CENTAINE },
			{ "X",ChiffresParUnite.DIZAINE } ,
			{ "M",ChiffresParUnite.MILLIER}
		});
	}
	@Parameter 
	public String chiffreRomainEntree;
	
	@Parameter(value = 1)
	public  ChiffresParUnite nombreRomainAttendu;
	
	
	@Test
	public void recupererUniteAPartirChiffreRomainCas00TU() {
		// GIVEN
		
		// WHEN
		ChiffresParUnite resultat = ChiffresParUnite.recupererUniteAPartirChiffreRomain(chiffreRomainEntree);
		
		// THEN
		Assert.assertEquals(nombreRomainAttendu, resultat);
		
	}
}
