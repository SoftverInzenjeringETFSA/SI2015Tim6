package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;


public class Racun implements java.io.Serializable {
	long id;
	Date datum_i_vrijeme;
	long akcija_popust_id;
	int broj_racuna;
	
	public Racun() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatum_i_vrijeme() {
		return datum_i_vrijeme;
	}
	public void setDatum_i_vrijeme(Date datum_i_vrijeme) {
		this.datum_i_vrijeme = datum_i_vrijeme;
	}
	public long getAkcija_popust_id() {
		return akcija_popust_id;
	}
	public void setAkcija_popust_id(long akcija_popust_id) {
		this.akcija_popust_id = akcija_popust_id;
	}
	public int getBroj_racuna() {
		return broj_racuna;
	}
	public void setBroj_racuna(int broj_racuna) {
		this.broj_racuna = broj_racuna;
	}
}
