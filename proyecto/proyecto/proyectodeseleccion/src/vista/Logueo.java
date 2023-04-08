package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import mantenimiento.GestionUsuarioDAO;
import utils.HiloTiempo;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class Logueo extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblMensaje;
	public static JLabel lblTiempo;
	// Instanciar un objeto
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	// Usuario publico para acceder a los datos desde otras clases
	public static Usuario usuario = new Usuario();

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
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/avatar.png")));
		setTitle("CIBERFARMA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(114, 36, 96, 20);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(114, 83, 96, 20);
		contentPane.add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 36, 103, 22);
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
		txtClave.setBounds(205, 80, 103, 20);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(114, 116, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setEnabled(false);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(226, 116, 89, 23);
		contentPane.add(btnSalir);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/avatar.png")));
		lblFondo.setBounds(0, 11, 127, 184);
		contentPane.add(lblFondo);

		lblMensaje = new JLabel("Esta ventana de cerrar\u00E1 en");
		lblMensaje.setBounds(74, 11, 171, 14);
		contentPane.add(lblMensaje);

		lblTiempo = new JLabel("30 s");
		lblTiempo.setBounds(249, 11, 46, 14);
		contentPane.add(lblTiempo);

		// metodo que se encarga de inciar con el proceso de conteo
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
