package interfaces;

import java.awt.Component;

import javax.swing.JTextArea;

public interface Utils {

public void mensajeError(Component pos,String msj);
	
	public void mensajeExito(Component pos,String msj);
	
	public void imprimir(JTextArea txtS, String cad);
	
	
	
}
