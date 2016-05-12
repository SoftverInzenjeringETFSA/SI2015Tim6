package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class Kasir extends Uposlenik implements java.io.Serializable{
	@Id
	@GeneratedValue
	long uposlenik_id;
	Date datumZaposljenja;
	
public Kasir() {
	super();
	this.datumZaposljenja=new Date();
	
}

public Kasir(String pImePrezime, Date pDatumRodjenja, String pJMBG, String pBrojTel) {
	this.imePrezime=pImePrezime;
	this.datumRodjenja=pDatumRodjenja;
	this.jmbg=pJMBG;
	this.brojTelefona=pBrojTel;
	this.datumZaposljenja= new Date();
}
	
	public Date getDatum_zaposljenja() {
		return datumZaposljenja;
	}

	public void setDatum_zaposljenja(Date pDatumZaposljenja) {
		this.datumZaposljenja = pDatumZaposljenja;
	}


		

	
	public void Prijava() {
		//implementation
	}
	
	public void Odjava() {
		//implementation
	}

	@Override
	public void promjeniImePrezime(String pImePrezime) {
		this.imePrezime=pImePrezime;
		
	}

	@Override
	public void promjeniDatumRodj(Date pDatum) {
		this.datumRodjenja=pDatum;
		
	}

	@Override
	public void promjeniBrojTel(String pTel) {
		this.brojTelefona=pTel;
		
	}
	
	

}
