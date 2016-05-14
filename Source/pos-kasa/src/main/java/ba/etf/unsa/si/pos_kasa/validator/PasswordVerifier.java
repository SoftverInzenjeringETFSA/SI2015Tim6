package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasswordVerifier extends AbstractValidator{
	
	public PasswordVerifier(JComponent c, String message) {
	 super(c,message);
	}

	@Override
	protected boolean validationCriteria(JComponent textFieldpassword) {
		String password = ((JTextField) textFieldpassword).getText();
		boolean isValid = true;
		if (password == null || password.length() < 5) {
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
