package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import clases.TipoUsuario;
import clases.Usuario;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Tool;
import utils.Validaciones;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class FrmUsuario extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel lblIdUsuario;
	private JTextField txtIdUsuario;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JLabel lblContraseña;
	private JTable tbUsuarios;
	private JScrollPane scrollPane;
	private JButton btnRegistrar;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoUsuarioDAO gtipUser = new GestionTipoUsuarioDAO();
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();

	private JLabel lblTipoUsuario;
	private JComboBox<Object> cboTipoUsuario;
	private JButton btnBuscarCargo;
	private JPasswordField txtClave;
	private JButton btnNuevo;
	private JButton btnActualizar;
	private JButton btnEliminar;

	public static void main(String[] args) {

		FrmUsuario form = new FrmUsuario();
		form.setVisible(true);

	}

	public FrmUsuario() {
		getContentPane().setBackground(new Color(192, 192, 192));

		setTitle("USUARIO");
		setBounds(100, 100, 667, 432);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		this.getContentPane().setLayout(null);

		lblIdUsuario = new JLabel("IdUsuario");
		lblIdUsuario.setBounds(27, 24, 73, 14);
		getContentPane().add(lblIdUsuario);

		txtIdUsuario = new JTextField();
		txtIdUsuario.setBounds(22, 49, 78, 20);
		getContentPane().add(txtIdUsuario);
		txtIdUsuario.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(179, 104, 135, 20);
		getContentPane().add(txtNombre);

		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(179, 79, 73, 14);
		getContentPane().add(lblNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(338, 48, 150, 20);
		getContentPane().add(txtApellido);

		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(343, 24, 73, 14);
		getContentPane().add(lblApellido);

		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(184, 24, 87, 14);
		getContentPane().add(lblContraseña);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 624, 228);
		getContentPane().add(scrollPane);

		tbUsuarios = new JTable();
		tbUsuarios.addMouseListener(this);
		tbUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuarios);

		btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(587, 28, 47, 41);
		getContentPane().add(btnRegistrar);

		model = new DefaultTableModel();
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Cargo");
		

		tbUsuarios.setModel(model);

		lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setBounds(348, 79, 73, 14);
		getContentPane().add(lblTipoUsuario);

		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.setBounds(338, 103, 156, 22);
		getContentPane().add(cboTipoUsuario);

		btnBuscarCargo = new JButton("");
		btnBuscarCargo.addActionListener(this);
		btnBuscarCargo.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/busca.png")));
		btnBuscarCargo.setBounds(110, 34, 47, 35);
		getContentPane().add(btnBuscarCargo);

		txtClave = new JPasswordField();
		txtClave.setBounds(179, 49, 73, 20);
		getContentPane().add(txtClave);

		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(522, 24, 47, 43);
		getContentPane().add(btnNuevo);

		btnActualizar = new JButton("");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/update (1).png")));
		btnActualizar.setBounds(532, 89, 45, 35);
		getContentPane().add(btnActualizar);

		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/delete (2).png")));
		btnEliminar.setBounds(596, 89, 38, 35);
		getContentPane().add(btnEliminar);

		// Mostrar datos en la tabla
		cargarDataUsuario();
		// mostrar datos de baja de la tabla
		mostrarData(0);
		//mostrar datos del CBO
		cargarTipoUsuario();

	}

	private void cargarTipoUsuario() {
		
		cboTipoUsuario.setSelectedIndex(-1);
		cboTipoUsuario.addItem("Seleccione un cargo");
		for (TipoUsuario obj : gtipUser.listarTipoUsuarios()) {
			cboTipoUsuario.addItem(obj.getDescripCargo());
		}
		
		
	}

	private void mostrarData(int posFila) {
		// declarar variables
		String user, pass, nomb, ape,carg;
		// paso 1 : obtener los datos de la tabla
		user = tbUsuarios.getValueAt(posFila, 0).toString();
		pass = tbUsuarios.getValueAt(posFila, 1).toString();
		nomb = tbUsuarios.getValueAt(posFila, 2).toString();
		ape = tbUsuarios.getValueAt(posFila, 3).toString();
		carg = tbUsuarios.getValueAt(posFila,4).toString();

		// paso 2: eEnviar los datos de la tabla a la cajas de texto
		txtIdUsuario.setText(user);
		txtClave.setText(pass);
		txtNombre.setText(nomb);
		txtApellido.setText(ape);
		cboTipoUsuario.setSelectedItem(carg);

	}

	private void cargarDataUsuario() {
		// 1.Limpiar la tabla
		model.setRowCount(0);
		// 2.llamar al proceso de consulta
		ArrayList<Usuario> lista = gUser.listarUsuarios();
		
		
		
		// crear un bucle para el recorrido
		for (Usuario u : lista) {
			//MOSTRAR VALOR DEL CBO EN CARGO
			String cargo = null;
			
			for(TipoUsuario obj:gtipUser.listarTipoUsuarios()) {
				if(obj.getIdcargo()==u.getCargo()) {
					cargo = obj.getDescripCargo();
				}
			}
			
			// crear un arreglo
			Object fila[] = { u.getUsuario(), u.getClave(), u.getNombre(), u.getApellido(),cargo

			};
			// a�adir la fila a la tabla
			model.addRow(fila);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarCargo) {
			actionPerformedBtnBuscarCargo(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		// variables
		String user, pass, nomb, ape;
		int carg;
		// entradas
		user = getUsuario();
		pass = getClave();
		nomb = getNombre();
		ape = getApellido();
		carg = getCargo();

		// validar

		if (user == null || pass == null || nomb == null || ape == null || carg == -1) {
			return;
		} else {
			Usuario u = new Usuario();
			// setear ---> asignar los nuevos valores ingresados por la gui a los atributos
			// privados
			u.setUsuario(user);
			u.setClave(pass);
			u.setNombre(nomb);
			u.setApellido(ape);
			u.setCargo(carg);
			

			// Llamar al proceso --->> metodo registra que se encuentra en la clase
			// "GestionUsuarioDAO"
			int ok = gUser.registrar(u);
			// validar el resultado del proceso de registro
			if (ok == 0) {
				mensajeError("Error en el registro");

			} else {
				mensajeExito("Registro Exitiso");
				cargarDataUsuario();
			}
		}
		// procesos

		// salidas

	}

	private int getCargo() {
	
		return cboTipoUsuario.getSelectedIndex();
	}

	private String getApellido() {
		String ape = null;
		if (txtApellido.getText().length() == 0) {
			mensajeError("Ingresar el apellido");
			txtApellido.setText("");
			txtApellido.requestFocus();
		} else if (txtApellido.getText().trim().matches(Validaciones.TEXTO)) {
			ape = txtApellido.getText().trim();
		} else {
			mensajeError("El apellido ingreado no cumple con el formato");
			txtApellido.setText("");
			txtApellido.requestFocus();

		}
		return ape;
	}

	private String getNombre() {
		String nomb = null;
		if (txtNombre.getText().length() == 0) {
			mensajeError("Ingresar el nombre");
			txtNombre.setText("");
			txtNombre.requestFocus();
		} else if (txtNombre.getText().trim().matches(Validaciones.TEXTO)) {
			nomb = txtNombre.getText().trim();
		} else {
			mensajeError("El nombre ingreado no cumple con el formato");
			txtNombre.setText("");
			txtNombre.requestFocus();

		}
		return nomb;
	}

	private String getClave() {
		String clave = null;
		// aplicar c�digo para encriptar la clave

		clave = encriptado(String.valueOf(txtClave.getPassword()));
		return clave;
	}

	private String encriptado(String pass) {
		// 01

		StringBuilder encriptado = new StringBuilder();

		// 02 asignarle el texto a la variable encriptado

		encriptado.append(pass);
		// 03 reemplazar //a->e, e->i, i->o, o->u, u->a

		for (int i = 0; i < encriptado.length(); i++) {

			switch (encriptado.charAt(i)) {

			case 'a':
				encriptado.setCharAt(i, 'e');
				break;

			case 'e':
				encriptado.setCharAt(i, 'i');
				break;

			case 'i':
				encriptado.setCharAt(i, 'o');
				break;

			case 'o':
				encriptado.setCharAt(i, 'u');
				break;

			case 'u':
				encriptado.setCharAt(i, 'a');
				break;

			}

		}
		return encriptado.reverse().toString();
	}

	private String getUsuario() {
		String user = null;
		if (txtIdUsuario.getText().length() == 0) {
			mensajeError("Ingresar el usuario");
			txtIdUsuario.setText("");
			txtIdUsuario.requestFocus();
		} else if (txtIdUsuario.getText().trim().matches(Validaciones.USER_USUARIO)) {
			user = txtIdUsuario.getText().trim();
		} else {
			mensajeError("Error en el formato.Ej U001 � u001");
			txtIdUsuario.setText("");
			txtIdUsuario.requestFocus();

		}
		return user;
	}

	private void mensajeExito(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);

	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema !", 1);

	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevoUsuario();
	}

	private void nuevoUsuario() {
		txtIdUsuario.setText("");
		txtClave.setText("");
		txtNombre.setText("");
		txtApellido.setText("");

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarUsuario();
	}

	private void actualizarUsuario() {
		// Declarar las variables
		// variables
		String user, pass, nomb, ape;
		// entradas
		user = getUsuario();
		pass = getClave();
		nomb = getNombre();
		ape = getApellido();
		// validar

		if (user == null || pass == null || nomb == null || ape == null) {
			return;
		} else {
			Usuario u = new Usuario();
			// setear ---> asignar los nuevos valores ingresados por la gui a los atributos
			// privados
			u.setUsuario(nomb);
			u.setClave(pass);
			u.setNombre(nomb);
			u.setApellido(ape);

			// Llamar al proceso --->> actualizar
			// "GestionUsuarioDAO"
			int ok = gUser.actualizar(u);
			// validar el resultado del proceso de actualizar
			if (ok == 0) {
				mensajeError("Error al actualizar");

			} else {
				mensajeExito("Actualizacion Exitiso");
				cargarDataUsuario();
			}
		}

		// crear un objeto de tipo "usuario"

		// setear los atributos(asignar los nuevos valores a los atributos privados

	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarUsuario();
	}

	private void eliminarUsuario() {
		// Declarar variable
		String usuario;
		int opcion;
		// obtener el codigo
		usuario = getUsuario();
		// validar
		if (usuario == null) {
			return;
		} else {
			// Venta de confirmacion
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {// Si se va eliminar
				// llamar al proceso de eliminar
				int ok = gUser.eliminar(usuario);
				// validar el resultado del proceso
				if (ok == 0) {
					mensajeError("Codigo no existe");
				} else {
					mensajeError("Usuario eliminado");
					cargarDataUsuario();
				}
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbUsuarios) {
			mouseClickedTbUsuarios(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTbUsuarios(MouseEvent e) {
		// obtener el valor de la fila seleccionada
		int posFila = tbUsuarios.getSelectedRow();
		// mostrar data
		mostrarData(posFila);
	}
	protected void actionPerformedBtnBuscarCargo(ActionEvent e) {
		buscarDatosUsuario();
	}

	private void buscarDatosUsuario() {
		String usuario;
		// paso1 --> obtener el codigo ingresado
		usuario = getUsuario();
		// paso2 --> validar que el codigo ingresado responda al formato
		if (usuario == null) {
			return;
		} else {
			// llamar al proceso de busqueda
			Usuario user = gUser.buscarUsuario(usuario);
			// validar el resultado del proceso
			if (user == null) {
				mensajeError("Codigo no exite");
			} else {
				txtClave.setText(user.getClave());
				txtNombre.setText(user.getNombre());
				txtApellido.setText(user.getApellido());
				cboTipoUsuario.setSelectedIndex(user.getCargo());
		
			}
		}
		
	}
}
