package utils;

import vista.FrmPreLoader;

public class HiloBarraProgreso extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <=100; i++) {
			FrmPreLoader.prbCarga_1.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
