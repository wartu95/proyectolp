package utils;

import javax.swing.JLabel;
import javax.swing.JFrame;
import vista.Logueo;

public class HiloTiempo extends Thread {
	//declarar componentes privados
	
	private JLabel lblTiempo1;
	private JFrame ventana;
		
	
		
		
	public HiloTiempo(JLabel lblTiempo1, JFrame ventana) {
		super();
		this.lblTiempo1 = lblTiempo1;
		this.ventana = ventana;
	}


	
	@Override
	public void run() {
		for (int i = 20; i >= 0; i--) {
			lblTiempo1.setText(i + "s");
			try {
				Thread.sleep(1000);// pausa al proceso
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(i);
		}
		this.ventana.dispose();
	}

	
}
