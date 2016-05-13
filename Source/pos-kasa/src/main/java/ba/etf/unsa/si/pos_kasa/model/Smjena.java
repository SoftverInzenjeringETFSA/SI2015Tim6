package ba.etf.unsa.si.pos_kasa.model;

import java.sql.Timestamp;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class Smjena implements java.io.Serializable {
		@Id
		@GeneratedValue
		long id;
		Timestamp pocetak_smjene;
		Timestamp kraj_smjene;
		long uposlenik_id; //ovdje ne moze bit long vec objekat uposlenika mapiran sa many to one anotacijom
		//@ManyToOne
		//Uposlenik uposlenik;
		//promjenit u bazi
				
	    public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Timestamp getPocetakSmjene() {
			return pocetak_smjene;
		}
		public void setPocetakSmjene(Timestamp pocetak_smjene) {
			this.pocetak_smjene = pocetak_smjene;
		}
		public Timestamp getKrajSmjene() {
			return kraj_smjene;
		}
		public void setKrajSmjene(Timestamp kraj_smjene) {
			this.kraj_smjene = kraj_smjene;
		}
		
		public long getUposlenik_id() {
			return uposlenik_id;
		}
		public void setUposlenik_id(long uposlenik_id) {
			this.uposlenik_id = uposlenik_id;
		}
		public Smjena() {
			super();
		}
		public Smjena(long id, Timestamp pocetak_smjene, Timestamp kraj_smjene, long kasir_id) {
			super();
			this.id = id;
			this.pocetak_smjene = pocetak_smjene;
			this.kraj_smjene = kraj_smjene;
			this.uposlenik_id = uposlenik_id;
		}
	}


	
	
	
	
	

