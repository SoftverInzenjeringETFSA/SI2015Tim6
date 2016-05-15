package ba.etf.unsa.si.pos_kasa.validator;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasswordConfirmVerifier extends AbstractValidator {
	
	JComponent prvi;

	public PasswordConfirmVerifier(JComponent drugi, String message, JComponent prvi) {
		super(drugi,message);
		this.prvi=prvi;
	}
	@Override
	protected boolean validationCriteria(JComponent c) {
		String drugi = ((JTextField) c).getText();
		String prviPassword = ((JTextField) prvi).getText();
		boolean isValid = true;
		isValid=provjeriIspravnost(prviPassword, drugi);
		
		return isValid;
	}

	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}
	
 private boolean provjeriIspravnost(String prvi,String drugi) {
	 boolean isValid=true;
	 
	 if (drugi == null || drugi.length() < 5 || !prvi.equals(drugi)) {
			isValid = false;
		}
	 return isValid;
	 
 }
}
	


