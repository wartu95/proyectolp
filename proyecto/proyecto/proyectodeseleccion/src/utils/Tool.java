package utils;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Tool {
	public static void mensajeError(Component pos,String msj) {
		JOptionPane.showMessageDialog(pos, msj, "ERROR!",0);
	}

	
	public static void mensajeExito(Component pos, String msj) {
		JOptionPane.showMessageDialog(pos, msj, "EXITO!",1);
	}


	public static int mensajeConfirmacion (Component pos, String msj) {
		return JOptionPane.showConfirmDialog(pos,msj,"CONFIRMACION", JOptionPane.YES_NO_OPTION);
		
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Formatter ft = new Formatter();
	
	
}
