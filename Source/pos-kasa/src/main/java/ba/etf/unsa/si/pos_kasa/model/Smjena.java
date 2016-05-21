package ba.etf.unsa.si.pos_kasa.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class Smjena implements java.io.Serializable {
		@Id
		@GeneratedValue
		long id;
		@Column(name="pocetak_smjene")
		private Date pocetak_smjene;
		@Column(name="kraj_smjene")
		private Date kraj_smjene;
		@Column(name="uposlenik_id")
		long uposlenik_id;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Date getPocetak_smjene() {
			return pocetak_smjene;
		}
		public void setPocetak_smjene(Date pocetak_smjene) {
			this.pocetak_smjene = pocetak_smjene;
		}
		public Date getKraj_smjene() {
			return kraj_smjene;
		}
		public void setKraj_smjene(Date kraj_smjene) {
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
		public Smjena(long id,Date pocetak_smjene,Date kraj_smjene,long uposlenik_id) {
			super();
			this.id = id;
			this.pocetak_smjene=pocetak_smjene;
			this.kraj_smjene=kraj_smjene;
			this.uposlenik_id = uposlenik_id;
		}
	}

