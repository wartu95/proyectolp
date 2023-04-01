package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class Logueo extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JLabel lblMensaje;
	private JLabel lblTiempo;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logueo frame = new Logueo();
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
	public Logueo() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(33, 102, 76, 17);
		contentPane.add(lblUsuario);
		
		lblContraseña = new JLabel("Constrase\u00F1a :");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraseña.setBounds(35, 156, 102, 14);
		contentPane.add(lblContraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(143, 99, 101, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(143, 150, 101, 20);
		contentPane.add(txtClave);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(35, 211, 89, 23);
		contentPane.add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(170, 211, 89, 23);
		contentPane.add(btnSalir);
		
		lblMensaje = new JLabel("Esta ventana de cerrar\u00E1 en");
		lblMensaje.setBounds(86, 24, 171, 14);
		contentPane.add(lblMensaje);
		
		lblTiempo = new JLabel("10 s");
		lblTiempo.setBounds(231, 24, 46, 14);
		contentPane.add(lblTiempo);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Logueo.class.getResource("/img/Screenshot_1.png")));
		lblNewLabel.setBounds(0, 0, 455, 277);
		contentPane.add(lblNewLabel);
	}
}
