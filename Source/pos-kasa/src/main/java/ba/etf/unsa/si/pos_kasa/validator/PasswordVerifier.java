package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.*;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasswordVerifier extends AbstractValidator{
	
	public PasswordVerifier(JComponent c, String message) {
	 super(c,message);
	}
	private static String reg1=".*[a-z].*";
	private static String reg2=".*[A-Z].*";
	private static String reg3=".*[0-9].*";
	@Override
	protected boolean validationCriteria(JComponent textFieldpassword) {
		String password = ((JTextField) textFieldpassword).getText();
		boolean isValid = true;
		if (password.matches(reg1) &&  password.matches(reg2) && password.matches(reg3) && password.length()> 7) {
			return true;
			
		}
		else{return false;}
		
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}

}
