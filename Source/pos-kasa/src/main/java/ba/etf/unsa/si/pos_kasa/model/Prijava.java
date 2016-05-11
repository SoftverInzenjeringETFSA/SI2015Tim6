package ba.etf.unsa.si.pos_kasa.model;
 import java.util.Date;

 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.Table;


 @Entity
 @Table(name="prijava")
 public class Prijava implements java.io.Serializable{

     /**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;

 	 @Id
     @Column(name="prijavaID")
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
	
	private Date datumPrijave;   
	
	public Prijava() {
	}
	
	public Prijava(Kasir kasir) {
		this.kasir = kasir;
		this.datumPrijave = new Date();
	}

	public void setKasir(Kasir kasir) {
		this.kasir = kasir;
	}

	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}
	
	public Kasir getKasir() {
		return kasir;
	}

	public Date getDatumPrijave() {
		return datumPrijave;
	}
}
