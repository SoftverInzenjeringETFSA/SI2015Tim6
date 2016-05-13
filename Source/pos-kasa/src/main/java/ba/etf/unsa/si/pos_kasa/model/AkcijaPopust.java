package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity

public class AkcijaPopust implements java.io.Serializable {
	@Id
	@GeneratedValue
	long id;
	Date datum_pocetka;
	Date datum_kraja;
	String opis;
	int iznos_popusta;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDatum_pocetka() {
		return datum_pocetka;
	}

	public void setDatum_pocetka(Date datum_pocetka) {
		this.datum_pocetka = datum_pocetka;
	}
	public Date getDatum_kraja() {
		return datum_kraja;
	}

	public void setDatum_kraja(Date datum_kraja) {
		this.datum_kraja = datum_kraja;
	}
	
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public int getIznos_popusta() {
		return iznos_popusta;
	}

	public void setIznos_popusta(int iznos_popusta) {
		this.iznos_popusta = iznos_popusta;
	}
	
	public AkcijaPopust(){
		
	}
	public AkcijaPopust(long id, Date datum_pocetka,Date datum_kraja,String opis,int iznos_popusta){
		this.id=id;
		this.datum_pocetka=datum_pocetka;
		this.datum_kraja=datum_kraja;
		this.opis=opis;
		this.iznos_popusta=iznos_popusta;
	}
}
