package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ImeVerifier extends AbstractValidator {

	public ImeVerifier() {
		// TODO Auto-generated constructor stub
	}

	public ImeVerifier(JComponent c, String message) {
		super(c, message);
	}

	@Override
	protected boolean validationCriteria(JComponent imeTextField) {
		String ime = ((JTextField) imeTextField).getText();
		boolean isValid = true;
		Pattern p = Pattern.compile("[^a-zšđžćčžŠĐČĆŽ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(ime);
		if (ime == null || ime.length() < 3 || ime.length() > 20 || m.find()) {
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
