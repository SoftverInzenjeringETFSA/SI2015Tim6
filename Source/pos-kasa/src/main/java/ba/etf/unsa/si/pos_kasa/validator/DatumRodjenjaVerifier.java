package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DatumRodjenjaVerifier extends AbstractValidator {

	public DatumRodjenjaVerifier(JComponent c, String message) {
		super(c,message);
	}
	@Override
	protected boolean validationCriteria(JComponent c) {
		String datumRodjenja = ((JTextField) c).getText();
		boolean isValid = true;
		Pattern p = Pattern.compile("^([0-9]{4}[\\-]{1}[0-9]{2}[\\-]{1}[0-9]{2})");
		Matcher m = p.matcher(datumRodjenja);
		if (datumRodjenja == null || !m.find()) {
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
