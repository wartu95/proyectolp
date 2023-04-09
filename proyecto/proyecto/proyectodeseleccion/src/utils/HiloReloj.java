package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class HiloReloj extends Thread {

	// componeten privado
	private JLabel lblReloj;

	// constructor
	public HiloReloj(JLabel lblReloj) {

		this.lblReloj = lblReloj;
	}

	@Override
	public void run() {
		while (true) {

			// Instanciar un objeto de la clase "Date" para ovbetne rla hora del sistema
			Date hora = new Date();
			// la hora
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			// mostrar la hora en la etuiqtea "lblReloj"
			lblReloj.setText(sdf.format(hora));
			
		}
	}

}
