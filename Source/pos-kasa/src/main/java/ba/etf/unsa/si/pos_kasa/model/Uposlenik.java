package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Uposlenik implements java.io.Serializable{
	@Id
	@GeneratedValue
	long id;
	public Uposlenik(long id, String imePrezime, Date datumRodjenja, String jmbg, String brojTelefona, String uloga) {
		super();
		this.id = id;
		this.imePrezime = imePrezime;
		this.datumRodjenja = datumRodjenja;
		this.jmbg = jmbg;
		this.brojTelefona = brojTelefona;
		this.uloga = uloga;
	}
	String uloga;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	String imePrezime;
	Date datumRodjenja;
	String jmbg;
	String brojTelefona;
	Date datum_zaposlenja;
	String username;
	String password;


public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

public Uposlenik(long id, String uloga, String imePrezime, Date datumRodjenja, String jmbg, String brojTelefona,
			Date datum_zaposlenja, String username, String password) {
		super();
		this.id = id;
		this.uloga = uloga;
		this.imePrezime = imePrezime;
		this.datumRodjenja = datumRodjenja;
		this.jmbg = jmbg;
		this.brojTelefona = brojTelefona;
		this.datum_zaposlenja = datum_zaposlenja;
		this.username = username;
		this.password = password;
	}

public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public Date getDatum_zaposlenja() {
		return datum_zaposlenja;
	}

	public void setDatum_zaposlenja(Date datum_zaposlenja) {
		this.datum_zaposlenja = datum_zaposlenja;
	}

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
