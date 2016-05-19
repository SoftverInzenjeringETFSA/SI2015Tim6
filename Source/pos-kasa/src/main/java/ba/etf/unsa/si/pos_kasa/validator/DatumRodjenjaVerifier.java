package ba.etf.unsa.si.pos_kasa.validator;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ba.etf.unsa.si.pos_kasa.view.messageBox;

public class DatumRodjenjaVerifier extends AbstractValidator {
	JComponent jmbg;

	public DatumRodjenjaVerifier(JComponent c, String message, JComponent jmbg) {
		super(c, message);
		this.jmbg = jmbg;
	}

	@Override
	protected boolean validationCriteria(JComponent c) {
		// JComponent komponenta =c;
		String datumRodjenja = ((JTextField) c).getText();
		String JMBG = ((JTextField) jmbg).getText();
		boolean isValid = true;
		boolean neispravanFormat=false;
		Pattern p = Pattern.compile("^([0-9]{4}[\\-]{1}[0-9]{2}[\\-]{1}[0-9]{2})");
		Matcher m = p.matcher(datumRodjenja);
		if ((datumRodjenja.length() > 10)) {
           // messageBox.infoBox("datum previse", "");
            neispravanFormat=true;
            changeErrorMessage("Unesite ispravan format u obliku YYYY-MM-DD!");
			return false;
		} else if (datumRodjenja == null) {
			neispravanFormat=true;
			changeErrorMessage("Niste unijeli datum. Unesite datum u formatu YYYY-MM-DD!");
			return false;
		} else if (!m.find()){
			 
				neispravanFormat=true;
				changeErrorMessage("Unesite ispravan format datuma u obliku YYYY-MM-DD!");
				return false;
			

		}
		int godina = Integer.parseInt(datumRodjenja.substring(0, 4));
		int mjesec = Integer.parseInt(datumRodjenja.substring(5, 7));
		int dan = Integer.parseInt(datumRodjenja.substring(8, 10));
		Date trenutnaGodinaDatum = new Date();
		String trenutnaGodinaString = trenutnaGodinaDatum.toString();
		int trenutnaGodina = Integer
				.parseInt((trenutnaGodinaDatum.toString()).substring(25, trenutnaGodinaString.length()));
		if (godina < 1900 || godina > trenutnaGodina) {
			changeErrorMessage("Godina ne smije biti manja od 1900 i veća od trenutne godine! ");
			return false;
		} else if (mjesec > 12) {
			changeErrorMessage("Uneseni broj mjeseca ne smije biti veći od 12!");
			return false;
		} else if (mjesec == 2 && !provjeriPrestupnuGodinu(godina) && dan == 29) {
			changeErrorMessage("Nevalidan unos dana za mjesec februar, godina nije prestupna!");
			return false;
		} else if (mjesec == 2 && !provjeriPrestupnuGodinu(godina) && dan > 28) {
			changeErrorMessage("Nevalidan unos dana za mjesec februar, mjesec Februar za unijetu godinu ima 28 dana!");
			return false;
		}

		else if ((mjesec == 1 || mjesec == 3 || mjesec == 5 || mjesec == 7 || mjesec == 8 || mjesec == 10
				|| mjesec == 12) && (dan > 31) && neispravanFormat==false ) {
			//if(neispravanFormat==false) System.out.println("format je uredu");
			changeErrorMessage("Uneseni dan u mjesecu nije validan, prekoračeni opseg, uneseni mjesec ima 31 dan!");
			return false;
		} else if ((mjesec == 4 || mjesec == 6 || mjesec == 9 || mjesec == 11) && dan > 30) {
			changeErrorMessage("Uneseni dan u mjesecu nije validan, prekoračeni oseg, uneseni mjesec ima 30 dana!");

			return false;

		} else if(!JMBG.equals("")){
			boolean godinaRodjenjaProvjera=true,mjesecRodjenjaProvjera=true,danRodjenjaProvjera=true;
			if (!JMBG.substring(4, 7).equals(datumRodjenja.substring(1, 4))) {
				godinaRodjenjaProvjera=false;
			}
			int mjesecJMBG = Integer.parseInt(JMBG.substring(2, 4));
			if (mjesecJMBG != mjesec) {
				mjesecRodjenjaProvjera=false;
				//changeErrorMessage("Mjesec kod unosa datuma rođenja ne odgovara unesenom mjesecu u polju JMBG!");
				//return false;
			}
			int danJMBG = Integer.parseInt(JMBG.substring(0, 2));
			if (danJMBG != dan) {
				danRodjenjaProvjera=false;
				//changeErrorMessage("Dan kod datuma rođenja neodgovara unesenom danu u polju JMBG!");
				//return false;
			}
			
			//slucajevi
			if(!godinaRodjenjaProvjera&&!danRodjenjaProvjera&&!mjesecRodjenjaProvjera)
			{
				changeErrorMessage("Godina, mjesec i dan kod unosa datuma rođenja ne odgovara unesenoj godini mjesecu i danu u polju JMBG!");
			    return false;
			}
			if(!godinaRodjenjaProvjera&&!mjesecRodjenjaProvjera&&danRodjenjaProvjera)
			{
				changeErrorMessage("Godina i mjesec kod unosa datuma rođenja ne odgovara unesenoj godini i mjesecu u polju JMBG!");
			    return false;
			}
			if(!godinaRodjenjaProvjera&&mjesecRodjenjaProvjera&&!danRodjenjaProvjera)
			{
				changeErrorMessage("Godina i dan kod unosa datuma rođenja ne odgovara unesenoj godini i danu u polju JMBG!");
			    return false;
			}
			if(!godinaRodjenjaProvjera&&mjesecRodjenjaProvjera&&danRodjenjaProvjera)
			{
				changeErrorMessage("Godina kod unosa datuma rođenja ne odgovara unesenoj godini u polju JMBG!");
			    return false;
			}
			if(godinaRodjenjaProvjera&&!mjesecRodjenjaProvjera&&!danRodjenjaProvjera)
			{
				changeErrorMessage("Mjesec i dan kod unosa datuma rođenja ne odgovara unesenom mjesecu i danu u polju JMBG!");
			    return false;
			}
			if(godinaRodjenjaProvjera&&!mjesecRodjenjaProvjera&&danRodjenjaProvjera)
			{
				changeErrorMessage("Mjesec kod unosa datuma rođenja ne odgovara unesenom mjesecu u polju JMBG!");
			    return false;
			}
			
		}

		return isValid;
	}

	protected boolean provjeriPrestupnuGodinu(int godina) {

		if ((godina % 4 == 0) || (godina % 400 == 0) && (!(godina % 100 == 0) || (godina % 400 == 0))) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}

}
