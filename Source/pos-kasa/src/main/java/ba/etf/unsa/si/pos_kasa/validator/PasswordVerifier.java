package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.*;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasswordVerifier extends AbstractValidator {

	public PasswordVerifier(JComponent c, String message) {
		super(c, message);
	}

	private  String reg1 = ".*[a-z].*";
	private  String reg2 = ".*[A-Z].*";
	private  String reg3 = ".*[0-9].*";

	@Override
	protected boolean validationCriteria(JComponent textFieldpassword) {
		String password = ((JTextField) textFieldpassword).getText();
		boolean isValid = true;
		if (password.length() < 8) {
			changeErrorMessage("Neispravan unos lozinke. Lozinka se sastoji iz malih, velikih slova, bar jednog broja i mora imati dužinu od minimalno 8 karaktera!");
			return false;

		} 
		else if (!password.matches(reg1) || !password.matches(reg2) || !password.matches(reg3)) {
			changeErrorMessage("Neispravan unos lozinke. Lozinka se sastoji iz malih, velikih slova, bar jednog broja i mora imati dužinu od minimalno 8 karaktera!");

			return false;
		}
return isValid;
	}
	
	public boolean ispravnostLozinke(JComponent c) {
		return validationCriteria(c);
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}

}
