package Clases;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Utilidades {
	/*Para las interfaces*/
	public static void removeAllTable(JTable tabla) {
		while(true) {
			try{  
				DefaultTableModel model=(DefaultTableModel)tabla.getModel();
				model.removeRow(0);	
			}catch(Exception e) {
				break;
			}
		}
	}
	public static void println(String s, boolean b) {
		if(b) System.out.println(s);
	}
}
