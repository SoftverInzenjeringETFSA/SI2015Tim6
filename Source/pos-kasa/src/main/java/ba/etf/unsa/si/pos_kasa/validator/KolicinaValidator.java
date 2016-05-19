package ba.etf.unsa.si.pos_kasa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.view.FormaKategorije;

public class KolicinaValidator extends AbstractValidator {

	final static Logger logger = Logger.getLogger(KolicinaValidator.class.toString());
	public KolicinaValidator(JComponent c, String message) {
		 super(c,message);
		}

	//almir-vršio sam izmjene ovdje ne postoji validacija
	@Override
	protected boolean validationCriteria(JComponent c) {
		try{
			int d=0;
			Integer.parseInt(((JTextField) c).getText());
			return true;
		}
		catch(Exception e)
		{
			
			String poruka=e.getMessage();
			logger.info(poruka);
			return false;
			//throw new RuntimeException(e);
		}
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}
}
