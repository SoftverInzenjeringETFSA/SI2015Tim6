package ba.etf.unsa.si.pos_kasa.model;

import java.sql.Timestamp;
import java.util.Date;

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
		static Date pocetak_smjene;
		
		static Date kraj_smjene;
		long uposlenik_id;
		 
	
	    public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public static  Date getPocetakSmjene() {
			
			return pocetak_smjene;
		}
		public static void setPocetakSmjene(Date pocetak_smjene) {
			Smjena.pocetak_smjene = pocetak_smjene;
		}
		public  Date getKrajSmjene() {
			
			return kraj_smjene;
		}
		public static void setKrajSmjene(Date kraj_smjene) {
			Smjena.kraj_smjene = kraj_smjene;
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
		public Smjena(long id,Date pocetak_smjene,Date kraj_smjene,long uposlenik_id) {
			super();
			this.id = id;
			this.pocetak_smjene=pocetak_smjene;
			this.kraj_smjene=kraj_smjene;
			this.uposlenik_id = uposlenik_id;
		}
	}

