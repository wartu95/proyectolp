package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import vistas.FrmPrincipal;

public class HiloReloj extends Thread {
	//ATRIBUTO PRIVADO
	private JLabel lblHora;
	
	//CONSTRUCTOR
	public HiloReloj(JLabel lblHora) {
		this.lblHora = lblHora;
	}
	@Override
	public void run() {
		while (true) {
			//OBTENER LA FECHA DEL SISTEMA
			Date hora = new Date();
			//FORMATO PARA LA HORA
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
			//MOSTRAR LA HORA EN ETIQUETA "LBLHORA"
			lblHora.setText(sdf.format(hora));
		}
	}
}
