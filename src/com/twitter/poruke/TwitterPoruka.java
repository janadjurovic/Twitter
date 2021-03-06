package com.twitter.poruke;

/** 
 * Klasa TwitterPoruka
 * @author Jana Djurovic
 */

public class TwitterPoruka {
	/**
	 * Atributi korisnik i poruka koji su tipa String
	 */
	private String korisnik;
	private String poruka;

	/**
	 * Metoda getKorisnik() koja vraca String
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda setKorisnik() koja postavlja vrijednost atributa korisnik
	 * @param korisnik
	 * @throws RuntimeException() kada je proslijedjen null string ili prazan string
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda getPoruka() koja vraca String
	 * @return poruka
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Metoda setPoruka() koja postavlja vrijednost atributa poruka
	 * @param poruka
	 * @throws RuntimeException() kada je proslijedjen null string ili duzi od 140 karaktera
	 */

	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda toString() koja prikazuje podatke atributa korisnik i poruka
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
