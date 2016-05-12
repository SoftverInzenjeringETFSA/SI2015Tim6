package ba.etf.unsa.si.pos_kasa.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StornoRacun implements java.io.Serializable {

	public StornoRacun() {
		super();
	}
	public StornoRacun(long id, long racun_id, double iznos, Date datum_i_vrijeme) {
		super();
		this.id = id;
		this.racun_id = racun_id;
		this.iznos = iznos;
		this.datum_i_vrijeme = datum_i_vrijeme;
	}
	@Id
	@GeneratedValue
	long id;
	long racun_id;
	double iznos;
	Date datum_i_vrijeme;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRacun_id() {
		return racun_id;
	}
	public void setRacun_id(long racun_id) {
		this.racun_id = racun_id;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public Date getDatum_i_vrijeme() {
		return datum_i_vrijeme;
	}
	public void setDatum_i_vrijeme(Date datum_i_vrijeme) {
		this.datum_i_vrijeme = datum_i_vrijeme;
	}
}
