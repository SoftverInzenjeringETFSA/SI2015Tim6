package ba.etf.unsa.si.pos_kasa.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;

public class DateValidator extends AbstractValidator{

	public DateValidator(JComponent c, String message) {
		super(c,message);
	}	
	
	@Override
	protected boolean validationCriteria(JComponent c) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		Date date1=((JDateChooser)c).getDate();
		if(date1.before(date))
		{
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}

}
