package ba.etf.unsa.si.pos_kasa.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

import ba.etf.unsa.si.pos_kasa.view.FormaKategorije;

public class CijenaValidator extends AbstractValidator{

	final static Logger logger = Logger.getLogger(CijenaValidator.class.toString());
	public CijenaValidator(JComponent c, String message) {
		 super(c,message);
		}

	@Override
	protected boolean validationCriteria(JComponent CijenaBox) {
		try{
			Double d=new Double(0);
			d=d.parseDouble(((JTextField) CijenaBox).getText());
			return true;
		}
		catch(Exception e)
		{
			
			String poruka=e.getMessage();
			logger.info(poruka);			
			//throw new RuntimeException(e);
			return false;
		}
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}
}
