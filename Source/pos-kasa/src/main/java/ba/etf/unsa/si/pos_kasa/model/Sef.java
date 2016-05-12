package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;

public class Sef extends Uposlenik{

	@Override
	public void promjeniImePrezime(String pImePrezime) {
		this.imePrezime = pImePrezime;
	}

	@Override
	public void promjeniDatumRodj(Date pDatum) {
		this.datumRodjenja = pDatum;
	}

	@Override
	public void promjeniBrojTel(String pTel) {
		this.brojTelefona = pTel;
	}
	
	public void MjesecniIzvjestaj() {
		//implement
	}
	
	public void SedmicniIzvjestaj() {
		//implement
	}
	
	public void IzvjestajPoArtiklima() {
		//implementation
	}
	
	public void IzvjestajPoUposlenicima() {
		//implementation
	}
	
	

}
