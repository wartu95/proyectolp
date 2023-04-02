package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logueo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
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
		
		lblContrasena = new JLabel("Constrase\u00F1a :");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasena.setBounds(35, 156, 124, 14);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(158, 103, 101, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(158, 150, 101, 20);
		contentPane.add(txtClave);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
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
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		validarAcceso();
		
	}
	// METODOS DE ENTRADA Y SALIDA
	public String leerUsuario() {
		
		String res = txtUsuario.getText();
		
		return res;
		
	}
	
	public String leerPassword() {
		
		String res = txtClave.getText();
		
		return res;
	}
	//METODOS VOID
	public void validarAcceso() {
		
		if (leerUsuario().equals("klisman")&& leerPassword().equals("123")) {
			FrmPrincipal ventana = new FrmPrincipal();
			ventana.setVisible(true);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "CONTRASENA INCORRECTA ", "ATENCION" , 0);
		}
		
	}
	
}
