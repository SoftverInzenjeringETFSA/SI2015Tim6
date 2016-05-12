package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;

public abstract class Uposlenik {

	String imePrezime;
	Date datumRodjenja;
	String jmbg;
	String brojTelefona;
	



public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

public Uposlenik()
{
	this.imePrezime = new String();
	this.datumRodjenja = new Date();
	this.jmbg = new String();
	this.brojTelefona = new String();
}

public abstract void promjeniImePrezime(String pImePrezime);
public abstract void promjeniDatumRodj(Date pDatum );
public abstract void promjeniBrojTel(String pTel);
}
