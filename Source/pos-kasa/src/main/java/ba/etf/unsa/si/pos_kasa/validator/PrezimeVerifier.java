package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PrezimeVerifier extends AbstractValidator {
	
	public PrezimeVerifier(JComponent c, String message) {
		super(c,message);
	}

	@Override
	protected boolean validationCriteria(JComponent prezimeTextField) {
		
		String prezime = ((JTextField) prezimeTextField).getText();
		boolean isValid = true;
		Pattern p = Pattern.compile("[^a-zšđžćčžŠĐČĆŽ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(prezime);
		if (prezime == null || prezime.length() < 3 || prezime.length() > 20 || m.find()) {
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
