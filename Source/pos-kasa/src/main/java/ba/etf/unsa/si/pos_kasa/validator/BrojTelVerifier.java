package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BrojTelVerifier extends AbstractValidator {
 
	public BrojTelVerifier(JComponent c, String message) {
		super(c,message);
	}
	@Override
	protected boolean validationCriteria(JComponent c) {
		String brojTel = ((JTextField) c).getText();
		boolean isValid = true;
		Pattern p = Pattern.compile("^([\\+]{1}[0-9]{5}[\\-]{1}[0-9]{3}[\\-]{1}[0-9]{3})");
		Matcher m = p.matcher(brojTel);
		if (brojTel == null || !m.find()) {
			isValid = false;
		}
		return isValid;
	}
	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}

}
