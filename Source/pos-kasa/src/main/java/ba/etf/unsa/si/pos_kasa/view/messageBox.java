package ba.etf.unsa.si.pos_kasa.view;

import javax.swing.JOptionPane;

public class messageBox {
	
	 public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }

}
