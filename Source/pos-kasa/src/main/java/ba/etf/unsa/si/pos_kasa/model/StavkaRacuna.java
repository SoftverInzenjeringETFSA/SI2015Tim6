package ba.etf.unsa.si.pos_kasa.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaRacuna implements java.io.Serializable {
	@Id
	@GeneratedValue
	long id;
	int kolicina;
	double ukupna_cijena;
	long artikal_id;
	long racun_id;
	public long getRacun_id() {
		return racun_id;
	}
	public void setRacun_id(long racun_id) {
		this.racun_id = racun_id;
	}
	public StavkaRacuna(long id, int kolicina, double ukupna_cijena, long artikal_id) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.ukupna_cijena = ukupna_cijena;
		this.artikal_id = artikal_id;
	}
	public StavkaRacuna() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public double getUkupna_cijena() {
		return ukupna_cijena;
	}
	public void setUkupna_cijena(double ukupna_cijena) {
		this.ukupna_cijena = ukupna_cijena;
	}
	public long getArtikal_id() {
		return artikal_id;
	}
	public void setArtikal_id(long artikal_id) {
		this.artikal_id = artikal_id;
	}
}
