package viewmodel;

public class ArtikalZaIzvjestajProdato {
	public String naziv;
	public String barkod;
	public double cijena;
	public Long kolicinaP;
	public ArtikalZaIzvjestajProdato(Long kolicina,String naziv,String barkod, double cijena)
	{
		this.naziv=naziv;
		this.barkod=barkod;
		this.cijena=cijena;
		this.kolicinaP=kolicina;
		
	}

}
