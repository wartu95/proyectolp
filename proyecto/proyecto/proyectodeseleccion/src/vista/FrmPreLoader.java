package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.HiloBarraProgreso;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmPreLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga_1;
	private JLabel lblSpinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPreLoader() {
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 302);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		prbCarga_1 = new JProgressBar();
		prbCarga_1.addChangeListener(this);
		prbCarga_1.setStringPainted(true);
		prbCarga_1.setBounds(0, 23, 329, 19);
		contentPane.add(prbCarga_1);

		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.BLUE);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(11, 11, 313, 14);
		contentPane.add(lblMensajes);

		lblSpinner = new JLabel("");
		lblSpinner.setIcon(new ImageIcon(FrmPreLoader.class.getResource("/img/loading1.gif")));
		lblSpinner.setBounds(41, 53, 250, 197);
		contentPane.add(lblSpinner);
		// Metodo para iniciar el conteo en la barra de progreso
		iniciarBarraProgreso();

	}

	private void iniciarBarraProgreso() {
		HiloBarraProgreso h = new HiloBarraProgreso();
		h.start();

	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga_1) {
			stateChangedPrbCarga_1(e);
		}
	}

	protected void stateChangedPrbCarga_1(ChangeEvent e) {
		//VALIDAR SI LA BRRA DE PROGRESO TIENE EL VALOR 100
		if (prbCarga_1.getValue() == 100) {
			//instanciar un objeto de tipo "FrmPrincipal"
			FrmPrincipal prin = new FrmPrincipal();
			//objeto sea visible
			prin.setVisible(true);
			//ubicacion
			prin.setLocationRelativeTo(this);
			//cerrar la ventan actual(barra de progreso)
			this.dispose();
		}
	}
}








