package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KategorijaValidator extends AbstractValidator {

	public KategorijaValidator(JComponent c, String message) {
		 super(c,message);
		}
	
	@Override
	protected boolean validationCriteria(JComponent c) {
		return false;
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		return false;
	}
	

}
