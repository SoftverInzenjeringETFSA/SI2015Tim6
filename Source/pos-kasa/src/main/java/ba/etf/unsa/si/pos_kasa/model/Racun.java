package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
import ba.etf.unsa.si.pos_kasa.model.*;

@Entity
public class Racun implements java.io.Serializable {
	@Id
	@GeneratedValue
	long id;
	Date datum_i_vrijeme;
	long akcijapopust_id;
	//long smjena_id;
	@GeneratedValue
	long broj_racuna;
	long smjena_id;
    
	//public List<Racun> get_racuni() {
	//	return _racuni;
	//}
	//public void set_racuni(List<Racun> _racuni) {
	//	this._racuni = _racuni;
	//}
	public Racun(long id, Date datum_i_vrijeme, long akcijapopust_id, long broj_racuna) {
		super();
		this.id = id;
		this.datum_i_vrijeme = datum_i_vrijeme;
		this.akcijapopust_id = akcijapopust_id;
		this.broj_racuna = broj_racuna;
	}

	public long getAkcijapopust_id() {
		return akcijapopust_id;
	}

	public Racun() {
		// TODO Auto-generated constructor stub
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
	public long getAkcijappopust_id() {
		return akcijapopust_id;
	}
	public void setAkcijapopust_id(long akcija_popust_id) {
		this.akcijapopust_id = akcija_popust_id;
	}
	public long getSmjena_id() {
		return smjena_id;
	}
	public void setSmjena_id(long smjena_id) {
		this.smjena_id = smjena_id;
	}
	public long getBroj_racuna() {
		return broj_racuna;
	}
	public void setBroj_racuna(long broj_racuna) {
		this.broj_racuna = broj_racuna;
	}
}
