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
	private JTextField txtUsuario;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/avatar.png")));
		setTitle("CIBERFARMA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(27, 79, 96, 20);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setForeground(Color.BLACK);
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(27, 126, 96, 20);
		contentPane.add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 80, 103, 22);
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
		txtClave.setBounds(133, 128, 103, 20);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(44, 188, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setEnabled(false);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(183, 188, 89, 23);
		contentPane.add(btnSalir);
		
		lblMensaje = new JLabel("Esta ventana de cerrar\u00E1 en");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setBounds(10, 11, 183, 14);
		contentPane.add(lblMensaje);
		
		lblTiempo = new JLabel("10 s");
		lblTiempo.setForeground(Color.RED);
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiempo.setBounds(183, 11, 69, 14);
		contentPane.add(lblTiempo);
		
		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/Screenshot_1.png")));
		lblFondo.setBounds(0, 0, 464, 271);
		contentPane.add(lblFondo);
		
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
