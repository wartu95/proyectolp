package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class HiloReloj extends Thread {

	// componeten privado
	private JLabel lblReloj1;

	// constructor
	public HiloReloj(JLabel lblReloj1) {

		this.lblReloj1 = lblReloj1;
	}

	@Override
	public void run() {
		while (true) {

			// Instanciar un objeto de la clase "Date" para ovbetne rla hora del sistema
			Date hora = new Date();
			// la hora
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			// mostrar la hora en la etuiqtea "lblReloj"
			lblReloj1.setText(sdf.format(hora));
		}
	}

}
