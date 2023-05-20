package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import mantenimiento.GestionUsuarioDAO;
import utils.HiloTiempo;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Logueo extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario ;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	// Instanciar un objeto
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	// Usuario publico para acceder a los datos desde otras clases
	public static Usuario usuario = new Usuario();
	private JLabel lblMensaje;
	private JLabel lblTiempo;
	private JLabel lblFondo;
	private JLabel lblNewLabel_1;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/logo-smv.png")));
		setTitle("Superintendencia de Mercado  Valores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/DMSans-Regular.ttf")).deriveFont(60f);
			
			JLabel lblUsuario = new JLabel("Usuario :");
			lblUsuario.setForeground(Color.BLACK);
			lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblUsuario.setBounds(60, 397, 96, 29);
			contentPane.add(lblUsuario);
			
			
			JLabel lblClave = new JLabel("Contrase\u00F1a:");
			lblClave.setForeground(Color.BLACK);
			lblClave.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblClave.setBounds(60, 486, 164, 29);
			contentPane.add(lblClave);
			
		} catch (FontFormatException | IOException e1) {
			
			e1.printStackTrace();
		}

		

		

		txtUsuario = new JTextField();
		txtUsuario.setBounds(60, 424, 267, 38);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedTxtClave(e);
			}
		});
		txtClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keyReleasedTxtClave(e);
			}
		});
		txtClave.setBounds(60, 513, 267, 38);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.setBackground(new Color(0, 0, 0));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(90, 578, 193, 29);
		contentPane.add(btnAceptar);
		btnAceptar.setEnabled(false);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(90, 617, 193, 31);
		contentPane.add(btnSalir);
		
		lblMensaje = new JLabel("Esta ventana de cerrar\u00E1 en");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setBounds(153, 675, 174, 14);
		contentPane.add(lblMensaje);
		
		lblTiempo = new JLabel("60 s");
		lblTiempo.setForeground(Color.RED);
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiempo.setBounds(348, 675, 42, 14);
		contentPane.add(lblTiempo);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		lblNewLabel_1.setBounds(149, 331, 120, 56);
		contentPane.add(lblNewLabel_1);
		
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/Login Page Wireframe Mobile UI Prototype.png")));
		lblFondo.setBounds(0, 0, 414, 842);
		contentPane.add(lblFondo);
		
		// iniciarConteo();
	}

	protected void keyReleasedTxtClave(KeyEvent e) {
		if (txtClave.getText().trim().length() >= 1) {
			btnAceptar.setEnabled(true);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		String user, clave;
		// Obtener los datos ingreados en la GUI
		user = getUsuario();
		clave = getClave();
		// validar
		if (user == null || clave == null) {
			return;
		} else {
			// llamar al proceso de validarAcceso
			usuario = gUser.ValidarAcceso(user, clave);
			// validar el resultado del proceso
			if (usuario == null) {
				mensajeError("Usuario y/o clave incorrecta");
			} else {
				cargarBarraProgreso();
				this.dispose();
			}
		}
	}

	private void cargarBarraProgreso() {
		enter();

	}

	private String getClave() {
		String pas = null;
		if (txtClave.getText().trim().length() == 0) {
			mensajeError("Error clave");
			txtClave.setText("");
			txtClave.requestFocus();
		} else {
			pas = String.valueOf(txtClave.getPassword());
		}
		return pas;
	}

	private String getUsuario() {
		String usr = null;
		if (txtUsuario.getText().trim().length() == 0) {
			mensajeError("Error Usuario");
			txtUsuario.setText("");
			txtUsuario.requestFocus();
		} else {
			usr = txtUsuario.getText().trim();
		}
		return usr;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);

	}

	private void iniciarConteo() {
		// Instanciar
		HiloTiempo h = new HiloTiempo(lblTiempo, frame);
		// EJECUTAR
		h.start();

	}

	void enter() {

		String user, clave;
		// Obtener los datos ingreados en la GUI
		user = getUsuario();
		clave = getClave();
		// validar
		if (user == null || clave == null) {
			return;
		} else {
			// llamar al proceso de validarAcceso
			usuario = gUser.ValidarAcceso(user, clave);
			// validar el resultado del proceso
			if (usuario == null) {
				mensajeError("Usuario y/o clave incorrecta");
			} else {
				FrmPreLoader barra = new FrmPreLoader();
				barra.setVisible(true);
				barra.setLocationRelativeTo(this);
				this.dispose();
			}
		}

	}

	protected void actionPerformedTxtClave(ActionEvent e) {
		enter();
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		iniciarConteo();
	}
}
