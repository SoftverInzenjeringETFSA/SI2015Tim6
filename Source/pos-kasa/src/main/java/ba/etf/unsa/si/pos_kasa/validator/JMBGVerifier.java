package ba.etf.unsa.si.pos_kasa.validator;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JMBGVerifier extends AbstractValidator {
	
	public JMBGVerifier(JComponent c, String message) {
	 super(c,message);
	}
	

	@Override
	protected boolean validationCriteria(JComponent JMBGTextField) {
		String JMBG = ((JTextField) JMBGTextField).getText();
		boolean isValid = true;
		//Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
		//Matcher m = p.matcher(JMBG);
		if (JMBG== null || JMBG.length()!=13) {
			isValid = false;
			//System.out.println(isValid+" PROVJERA prije validacije");
		}
		else
		{
			isValid=validirajIspravnostJMBG(JMBG);
			//System.out.println(isValid+" PROVJERA validacije");
		}
		
		return isValid;
	}
	
	private Boolean validirajIspravnostJMBG(String JMBG) {
		String s = "";
        String input = JMBG.substring(0,JMBG.length() - 1);
        int i = 0, i1 = 0, diff = 0;
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(0))).intValue() * 7);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(1))).intValue() * 6);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(2))).intValue() * 5);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(3))).intValue() * 4);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(4))).intValue() * 3);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(5))).intValue() * 2);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(6))).intValue() * 7);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(7))).intValue() * 6);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(8))).intValue() * 5);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(9))).intValue() * 4);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(10))).intValue() * 3);
        i = i + (Integer.valueOf(String.valueOf(JMBG.charAt(11))).intValue() * 2);
        i1 = i;
        i = i / 11;
        diff = i1 - (i * 11);
        if ((diff == 0) || (diff == 1)) {
            s = input + 0;
        } else {
            s = input + (11 - diff);
        }
        return s.equals(JMBG);
	}


	@Override
	protected boolean validationCriteria(JPasswordField textFieldpasswordConfirm) {
		// TODO Auto-generated method stub
		return false;
	}

}
