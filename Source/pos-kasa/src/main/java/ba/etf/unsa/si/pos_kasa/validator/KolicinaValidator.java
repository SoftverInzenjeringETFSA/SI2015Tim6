package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KolicinaValidator extends AbstractValidator {

	public KolicinaValidator(JComponent c, String message) {
		 super(c,message);
		}

	@Override
	protected boolean validationCriteria(JComponent c) {
		try{
			int d=0;
			Integer.parseInt(((JTextField) c).getText());
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}
}
