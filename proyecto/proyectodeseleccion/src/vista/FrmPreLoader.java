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
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmPreLoader  extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga_1;
	private JLabel lblSpinner;
	private JLabel lblsmv;
	private JLabel lbllogo;
	private JLabel lblNewLabel;

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
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblsmv = new JLabel("Superintendencia del Mercado de Valores");
		lblsmv.setForeground(Color.BLUE);
		lblsmv.setFont(new Font("Lucida Bright", Font.PLAIN, 10));
		lblsmv.setBounds(89, 312, 209, 31);
		contentPane.add(lblsmv);
		
		prbCarga_1 = new JProgressBar();
		//prbCarga_1.setUI(new MetalProgressBarUI());
		prbCarga_1.setForeground(UIManager.getColor("ProgressBar.selectionBackground"));
		prbCarga_1.addChangeListener(this);
		prbCarga_1.setStringPainted(true);
		prbCarga_1.setBounds(3, 186, 379, 26);
		
		
		
		
		contentPane.add(prbCarga_1);		

		JLabel lblMensajes = new JLabel("El sistema de la smv est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(new Color(0, 0, 0));
		lblMensajes.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(3, 214, 295, 14);
		contentPane.add(lblMensajes);

		ImageIcon logo = new ImageIcon(FrmPreLoader.class.getResource("/img/logo 90 x 90.png"));
		lbllogo = new JLabel(logo);
		lbllogo.setBounds(3, 266, 76, 77);
		contentPane.add(lbllogo);
		
		ImageIcon loading = new ImageIcon(FrmPreLoader.class.getResource("/img/logo3 180-180.gif"));
		lblNewLabel = new JLabel(loading);
		lblNewLabel.setBounds(104, 0, 180, 180);
		contentPane.add(lblNewLabel);

		ImageIcon gif = new ImageIcon(FrmPreLoader.class.getResource("/img/fondo blanco.png"));

		lblSpinner = new JLabel(gif);
		lblSpinner.setBounds(0, 0, gif.getIconWidth(), gif.getIconHeight());
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








