package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Uposlenik implements java.io.Serializable{
	@Id
	@GeneratedValue
	long id=0;
	@Column(name="ime_prezime")
	String imePrezime;
	@Column(name="datum_rođenja")
	String datumRodjenja;
	@Column(name="jmbg")
	String jmbg;
	@Column(name="broj_telefona")
	String brojTelefona;
	@Column(name="datum_zaposlenja")
	Date datumZaposlenja;
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	@Column(name="uloga")
	String uloga;
	

	

public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
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

	public Date getDatum_zaposlenja() {
		return datumZaposlenja;
	}

	public void setDatum_zaposlenja(Date datum_zaposlenja) {
		this.datumZaposlenja = datum_zaposlenja;
	}

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

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

public Uposlenik(String imePrezime, String datumRodjenja, String jmbg, String brojTelefona, String username, String password,String uloga) {
		this.uloga = uloga;
		this.imePrezime = imePrezime;
		this.datumRodjenja = datumRodjenja;
		this.jmbg = jmbg;
		this.brojTelefona = brojTelefona;
		this.datumZaposlenja = new Date();
		this.username = username;
		this.password = password;
	}
	
public Uposlenik()
{
	this.imePrezime = new String();
	this.datumRodjenja = new String();
	this.jmbg = new String();
	this.brojTelefona = new String();
	this.id= 0;
	this.datumZaposlenja = new Date();
	this.username= new String();
	this.password = new String();
	this.uloga= new String();
}
}
