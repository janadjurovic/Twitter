/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jana Djurovic
 *
 */
public class TwitterPorukaTest {
	
	private TwitterPoruka t;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#getKorisnik()}.
	 */
	@Test
	public void testGetKorisnik() {
		t.setKorisnik("Jana");
		assertEquals("Jana", t.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikSveOK() {
		t.setKorisnik("Jana");
		assertEquals("Jana", t.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		t.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan(){
		t.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#getPoruka()}.
	 */
	@Test
	public void testGetPoruka() {
		t.setPoruka("poruka");
		
		assertEquals("poruka", t.getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaSveOK() {
		t.setPoruka("neka poruka");
		
		assertEquals("neka poruka", t.getPoruka());
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		t.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPoruka140(){
		t.setPoruka("qwertyuiop[asdfghjkl;zxcvbnm,liuytsdfdxgcfjghkhjbvbbvbvnbffdfdgfdsdxcvewrtygvhvghjbgnhuytresdfghjbgvcdserdvfbygnhmjtgyuiopoiuytredfghjkljhfghjkhftyujhvftgdfghnbgvjhjdfghjbklmertyuiopdfghjklrghjklxcvbnmdfgvhbjkhnudcunoifyudrghj");
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		t.setKorisnik("Jana");
		t.setPoruka("poruka");
		
		assertEquals("KORISNIK:Jana PORUKA:poruka", t.toString());
	}

}
