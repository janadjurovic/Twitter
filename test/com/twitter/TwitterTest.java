/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Jana Djurovic
 *
 */
public class TwitterTest {

	private Twitter t;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		assertEquals(new LinkedList<TwitterPoruka>(), t.vratiSvePoruke());
	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiSveOK() {
		String korisnik = "Jana Djurovic";
		String poruka = "poruka";
		t.unesi(korisnik, poruka);
		assertEquals(korisnik, t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(poruka, t.vratiSvePoruke().getLast().getPoruka());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikNull() {
		String korisnik = null;
		String poruka = "poruka";
		t.unesi(korisnik, poruka);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaNull() {
		String korisnik = "Jana";
		String poruka = null;
		t.unesi(korisnik, poruka);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikPrazanString() {
		String korisnik = "";
		String poruka = "poruka";
		t.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		t.unesi(null, "");
		
		LinkedList<TwitterPoruka> lista = t.vratiSvePoruke();
		String tekst = lista.get(1).getKorisnik() + " " + lista.get(1).getPoruka();
		
		assertEquals("Jana poruka", tekst);


	}


	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		assertEquals(new TwitterPoruka[1], t.vratiPoruke(1, "Jana"));	
	}
	
	@Test
	public void testVratiPorukeSveOk() {
		t.unesi("Jana", "druga poruka");
		t.unesi("Milena", "poruka");
		t.unesi("Milica", "poruka");
		t.unesi("Katarina", "poruka");
		
		TwitterPoruka[] niz = t.vratiPoruke(3, "poruka");
		String tekst = niz[2].getKorisnik() + " " + niz[2].getPoruka();
		
		assertEquals("Milica poruka", tekst);
	}
	
	@Test (expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testVratiPoruke2() {
		t.unesi("Jana", "druga poruka");
		t.unesi("Milena", "poruka");
		t.unesi("Milica", "poruka");
		t.unesi("Katarina", "poruka");
		
		TwitterPoruka[] niz = t.vratiPoruke(3, "poruka");
		String tekst = niz[3].getKorisnik() + " " + niz[3].getPoruka();
		
		assertEquals("Katarina poruka", tekst);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(10, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(10, "");
	}

}
