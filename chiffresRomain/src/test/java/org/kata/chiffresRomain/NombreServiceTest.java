package org.kata.chiffresRomain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kata.chiffresRomain.exception.DonneesEntreesException;
import org.kata.chiffresRomain.service.impl.NombreService;

public class NombreServiceTest {

	NombreService nombreService=new NombreService();
	
	@Test
	public void testcalculerUniteAPartirIndexIterationCas00(){
		/* GIVEN */
		String nombre="123";
		int indexChiffreEnPartantdeLaGauche = 1;
		
		/* WHEN  */
		int resultat=nombreService.calculerUniteAPartirIndexIteration(nombre, indexChiffreEnPartantdeLaGauche);
		
		/* THEN */
		assertEquals(indexChiffreEnPartantdeLaGauche,resultat);
	}

	@Test
	public void testcalculerUniteAPartirIndexIterationCas01(){
		/* GIVEN */
		String nombre="123";
		int indexChiffreEnPartantdeLaGauche = 0;
		
		/* WHEN  */
		int resultat=nombreService.calculerUniteAPartirIndexIteration(nombre, indexChiffreEnPartantdeLaGauche);
		
		
		/* THEN */
		assertEquals(2,resultat);
	}
	
	@Test
	public void testrecupererChiffreDepuisNombreCas00(){
		/* GIVEN */
		String nombre = "123";
		int indexChiffreEnPartantdeLaGauche = 0;
		
		/* WHEN */
		String resultat=nombreService.recupererChiffreDepuisNombre(nombre, indexChiffreEnPartantdeLaGauche);
		
		/* THEN */
		assertEquals("1",resultat);
	}

	@Test(expected=DonneesEntreesException.class)
	public void testVerifierNombreAvantConversionRomainCas00() throws DonneesEntreesException{
		/* GIVEN */
		String nombre="-1";
		
		/* WHEN */
		nombreService.verifierNombreAvantConversionRomain(nombre);
	}
	
	@Test(expected=DonneesEntreesException.class)
	public void testVerifierNombreAvantConversionRomainCas01() throws DonneesEntreesException{
		/* GIVEN */
		String nombre="5001";
		
		/* WHEN */
		nombreService.verifierNombreAvantConversionRomain(nombre);
	}
}
