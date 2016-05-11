package ba.etf.unsa.si.pos_kasa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.util.Date;

@Entity
@Table(name="odjava")
public class Odjava implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="odjavaID")
	@GeneratedValue
	long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="kasir_id")
	private Kasir kasir;

	private Date datumOdjave;   
	



	public Odjava() {
	}
	
	public Odjava(Kasir kasir) {
		this.kasir = kasir;
		this.datumOdjave = new Date();
	}
	
	public Kasir getKasir() {
		return kasir;
	}
	
	public void setKasir(Kasir kasir) {
		this.kasir = kasir;
	}

	public Date getDatumOdjave() {
		return datumOdjave;
	}

	public void setDatumOdjave(Date datumOdjave) {
		this.datumOdjave = datumOdjave;
	}
}