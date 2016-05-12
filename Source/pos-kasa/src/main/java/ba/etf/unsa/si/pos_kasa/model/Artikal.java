package ba.etf.unsa.si.pos_kasa.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity

public class Artikal implements java.io.Serializable{
	@Id
	@GeneratedValue
	long id;
	String naziv;
	String barkod;
	String jedinica_mjere;
	double cijena;
	int zalihe_stanje;
	String opis;
	long kategorija_id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

	public String getBarkod() {
		return barkod;
	}

	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}
	
	public String getJedinica_mjere() {
		return jedinica_mjere;
	}

	public void setJedinica_mjere(String jedinica_mjere) {
		this.jedinica_mjere = jedinica_mjere;
	}
	
	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	

	public long getZalihe_stanje() {
		return zalihe_stanje;
	}

	public void setZalihe_stanje(int zalihe_stanje) {
		this.zalihe_stanje = zalihe_stanje;
	}
	

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	public long getKategorija_id() {
		return kategorija_id;
	}

	public void setKategorija_id(long kategorija_id) {
		this.kategorija_id = kategorija_id;
	}
	public Artikal() {
	}
	
}

