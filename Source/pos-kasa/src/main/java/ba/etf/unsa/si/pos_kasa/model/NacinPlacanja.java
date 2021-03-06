package ba.etf.unsa.si.pos_kasa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NacinPlacanja implements java.io.Serializable {
	@Id
	@GeneratedValue
	long id;
	double iznos;
	String vrstaplacanja_id;
	long racun_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public String getVrstaplacanja_id() {
		return vrstaplacanja_id;
	}
	public void setVrstaplacanja_id(String vrstaplacanja_id) {
		this.vrstaplacanja_id = vrstaplacanja_id;
	}
	public long getRacun_id() {
		return racun_id;
	}
	public void setRacun_id(long racun_id) {
		this.racun_id = racun_id;
	}
	public NacinPlacanja() {
		super();
	}
	public NacinPlacanja(long id, double iznos, String vrstaplacanja_id, long racun_id) {
		super();
		this.id = id;
		this.iznos = iznos;
		this.vrstaplacanja_id = vrstaplacanja_id;
		this.racun_id = racun_id;
	}
}
