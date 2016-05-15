package ba.etf.unsa.si.pos_kasa.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import ba.etf.unsa.si.pos_kasa.view.FormaKategorije;

import org.apache.log4j.Logger;

public class DateValidator extends AbstractValidator {

	final static Logger logger = Logger.getLogger(DateValidator.class.toString());
	public DateValidator(JComponent c, String message) {
		super(c, message);
	}
	
	@Override
	protected boolean validationCriteria(JComponent c) {
		try{
		String s=new String();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String reportDate = df.format((((JDateChooser)c).getDate()));
		if(reportDate==null||reportDate=="")
		{
			return false;
		}
		else
		{
			return true;
		}
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
