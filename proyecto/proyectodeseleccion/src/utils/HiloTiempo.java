package utils;

import javax.swing.JLabel;
import javax.swing.JFrame;

import vista.Logueo;

public class HiloTiempo extends Thread {
	//declarar componentes privados
	
	private JLabel lblTiempo;
	private JFrame ventana;
	
	//constructor
	public HiloTiempo(JLabel lblTiempo, JFrame ventana) {
		super();
		this.lblTiempo = lblTiempo;
		this.ventana = ventana;
	}
	
	@Override
	public void run() {
		for (int i = 10; i >= 0; i--) {
			lblTiempo.setText(i + "s");
			try {
				Thread.sleep(1000);// pausa al proceso
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(i);
		}
		ventana.dispose();
	}

	
}
