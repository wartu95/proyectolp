package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import utils.Tool;
import utils.Validaciones;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import clases.Contrato;
import clases.Participante;
import mantenimiento.GestionContratoDAO;
import mantenimiento.ParticipanteDAO;
import interfaces.Utils;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class FrmParticipante extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */

	private JPanel contentPane;
	private JTable tbParticipante;
	private JPanel panel_1;
	private JLabel lblIdContrato;
	private JButton btnBuscar;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_7;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JTextField txtNombres;
	private JLabel lblNombres;
	private JTextField txtDNI;
	private JLabel lblDNI;
	private JLabel lblDni;

	// instanciar
	Participante Pac = new Participante();

	ParticipanteDAO Pact = new ParticipanteDAO();
	// instanciar un objeto para modelar la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private ParticipanteDAO partDao;
	private JTextField txtIdParticipante;
	private GestionContratoDAO contDao;
	private DefaultTableModel modelo;
	private JButton btnNuevo;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmParticipante frame = new FrmParticipante();
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
	public FrmParticipante() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Participantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 681, 245);
		contentPane.add(scrollPane);

		tbParticipante = new JTable();
		scrollPane.setViewportView(tbParticipante);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 21, 681, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblIdContrato = new JLabel("ID. Participante :");
		lblIdContrato.setBounds(10, 24, 96, 14);
		panel_1.add(lblIdContrato);

		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(FrmParticipante.class.getResource("/img/query.png")));
		btnBuscar.setBounds(134, 33, 43, 26);
		panel_1.add(btnBuscar);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 70, 75, 14);
		panel_1.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(10, 90, 156, 20);
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);

		lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(332, 70, 75, 14);
		panel_1.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(332, 90, 156, 20);
		panel_1.add(txtCorreo);
		txtCorreo.setColumns(10);

		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(186, 121, 75, 14);
		panel_1.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(186, 143, 123, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(10, 143, 156, 20);
		panel_1.add(txtNombres);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 121, 123, 14);
		panel_1.add(lblNombres);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(186, 90, 123, 20);
		panel_1.add(txtDNI);

		lblDNI = new JLabel("");
		lblDNI.setBounds(186, 70, 75, 14);
		panel_1.add(lblDNI);

		lblDni = new JLabel("DNI:");
		lblDni.setBounds(186, 70, 75, 14);
		panel_1.add(lblDni);

		txtIdParticipante = new JTextField();
		txtIdParticipante.setColumns(10);
		txtIdParticipante.setBounds(10, 39, 114, 20);
		panel_1.add(txtIdParticipante);

		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmParticipante.class.getResource("/img/new (1).png")));
		btnNuevo.setBounds(187, 33, 37, 26);
		panel_1.add(btnNuevo);

		lblNewLabel_7 = new JLabel("TABLA DE PARTICIPANTE");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(0, 206, 701, 23);
		contentPane.add(lblNewLabel_7);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(133, 487, 89, 23);
		contentPane.add(btnRegistrar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(521, 487, 89, 23);
		contentPane.add(btnEliminar);

		// agregar columna
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("APELLIDOS");
		model.addColumn("NOMBRES");
		model.addColumn("DNI");
		model.addColumn("TELEFONO");
		model.addColumn("CORREO");

		// asociar tabla
		tbParticipante.setModel(model);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(311, 487, 119, 23);
		contentPane.add(btnActualizar);

		// mostrar datos en la tabla
		cargarDataParticipante();
		arranque();

	}

	private void arranque() {

		cargarTabla();
		correlativo();
		limpiar();

	}

	private void limpiar() {
		txtIdParticipante.setEditable(false);
		txtApellidos.setText("");
		txtNombres.setText("");
		txtDNI.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
	}

	private void correlativo() {
		@SuppressWarnings("resource")
		Formatter ft = new Formatter();

		ArrayList<Participante> list = partDao.ListarParticipante();

		if (list.size() == 0) {
			txtIdParticipante.setText("PA001");
		} else {
			int idParticipante = list.get(list.size() - 1).getIdParticipante();

			int n = (idParticipante) + 1;

			txtIdParticipante.setText("");
			txtIdParticipante.setText("PA" + ft.format("%03d", n));
		}

	}

	private void cargarTabla() {
		ArrayList<Participante> list = partDao.ListarParticipante();

		modelo.setRowCount(0);

		for (Participante part : list) {

			Object[] x = { part.getIdParticipante(), part.getApellido(), part.getNombre(), part.getDni(),
					part.getCorreo(), part.getTelefono()

			};
			modelo.addRow(x);
		}

	}

	private void cargarDataParticipante() {
		// limpiar la tabla
		model.setRowCount(0);
		// llamar al proceos de consulta
		ArrayList<Participante> lista = Pact.ListarParticipante();
		// crear un bucle para el recorrido
		for (Participante p : lista) {
			// crear un arreglo
			Object fila[] = { p.getIdParticipante(), p.getApellido(), p.getNombre(), p.getDni(), p.getTelefono(),
					p.getCorreo(),

			};
			// aÃ±adir la fila a la tabla
			model.addRow(fila);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}

	}

	void registrarDatos() {
		int idpar;
		String ape, nomb, dni, telef, corr;

		// entrada

		idpar = getIdParticipante();
		ape = getApellido();
		nomb = getNombre();
		dni = getDni();
		telef = getTelefono();
		corr = getCorreo();

		// validar
		// validar
		if (idpar == -1 || ape == null || nomb == null || dni == null || telef == null || corr == null) {
			return;
		} else {
			// procesos
			// crear un objeto de tipo "paciente"
			Participante p = new Participante();
			// setear --> asignar los nuevos valores ingresados por la gui a los atributos
			// privados
			p.setNombre(nomb);
			p.setApellido(ape);
			p.setDni(dni);
			p.setTelefono(telef);
			p.setCorreo(corr);

			// llamar al proceso --> metodo registrar que se encuentra en la clase
			// "PacienteDAO"
			int ok = Pact.registrar(p);
			// validar el resultado del proceso de registro
			if (ok == 0) {
				mensajeError("Error en el registro");
			} else {
				mensajeExistoso("Registro Existoso");
				cargarDataParticipante();
			}

		}

	}

	private void mensajeExistoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema !", 1);

	}

	private String getCorreo() {
		String corr = null;
		if (txtCorreo.getText().length() == 0) {
			mensajeError("Ingresar el telefono");
			txtCorreo.setText("");
			txtCorreo.requestFocus();
		} else if (txtCorreo.getText().trim().matches(Validaciones.CORREO_PAR)) {
			corr = txtCorreo.getText().trim();
		} else {
			mensajeError("El correo ingresado no cumple con el formato");
			txtCorreo.setText("");
			txtCorreo.requestFocus();
		}
		return corr;
	}

	private String getTelefono() {
		String telef = null;
		if (txtTelefono.getText().length() == 0) {
			mensajeError("Ingresar el telefono");
			txtTelefono.setText("");
			txtTelefono.requestFocus();
		} else if (txtTelefono.getText().trim().matches(Validaciones.TELEFONO_PAR)) {
			telef = txtTelefono.getText().trim();
		} else {
			mensajeError("El telefono ingresado no cumple con el formato");
			txtTelefono.setText("");
			txtTelefono.requestFocus();
		}
		return telef;
	}

	private String getDni() {
		String dni = null;
		if (txtDNI.getText().length() == 0) {
			mensajeError("Ingresar el apellido");
			txtDNI.setText("");
			txtDNI.requestFocus();
		} else if (txtDNI.getText().trim().matches(Validaciones.DNI_PAR)) {
			dni = txtDNI.getText().trim();
		} else {
			mensajeError("El DNI  ingresado no cumple con el formato");
			txtDNI.setText("");
			txtDNI.requestFocus();
		}
		return dni;
	}

	private String getNombre() {
		String nomb = null;
		if (txtNombres.getText().length() == 0) {
			mensajeError("Ingresar el nombre");
			txtNombres.setText("");
			txtNombres.requestFocus();
		} else if (txtNombres.getText().trim().matches(Validaciones.NOMBRE_PAR)) {
			nomb = txtNombres.getText().trim();
		} else {
			mensajeError("El nombre ingresado no cumple con el formato");
			txtNombres.setText("");
			txtNombres.requestFocus();
		}
		return nomb;
	}

	private String getApellido() {
		String ape = null;
		if (txtApellidos.getText().length() == 0) {
			mensajeError("Ingresar el apellido");
			txtApellidos.setText("");
			txtApellidos.requestFocus();
		} else if (txtApellidos.getText().trim().matches(Validaciones.APELLIDO_PAR)) {
			ape = txtApellidos.getText().trim();
		} else {
			mensajeError("El apellido  ingresado no cumple con el formato");
			txtApellidos.setText("");
			txtApellidos.requestFocus();
		}
		return ape;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);

	}

	private int getIdParticipante() {
		int cod = 0;
		if (txtIdParticipante.getText().trim().length() == 0) {
			mensajeError("INGRESAR EL CODIGO DEL PACIENTE");
			txtIdParticipante.setText("");
			txtIdParticipante.requestFocus();
		} else {
			try {
				cod = Integer.parseInt(txtIdParticipante.getText());
			} catch (NumberFormatException e) {
				mensajeError("Error en el formato del codigo");
				txtIdParticipante.setText("");
				txtIdParticipante.requestFocus();
			}

		}
		return cod;
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarParticipante();
	}

	private void actualizarParticipante() {
		// declarar las mvariables
		int idpar;
		String ape, nomb, dni, telef, corr;
		// entradas
		idpar = getIdParticipante();
		ape = getApellido();
		nomb = getNombre();
		dni = getDni();
		telef = getTelefono();
		corr = getCorreo();
		if (idpar == -1 || ape == null || nomb == null || dni == null || telef == null || corr == null) {
			return;
		} else {
			// procesos
			// crear un objeto de tipo "paciente"
			Participante p = new Participante();
			// setear --> asignar los nuevos valores ingresados por la gui a los atributos
			// privados
			p.setNombre(nomb);
			p.setApellido(ape);
			p.setDni(dni);
			p.setTelefono(telef);
			p.setCorreo(corr);

			// llamar al proceso --> metodo registrar que se encuentra en la clase
			// "PacienteDAO"
			int ok = Pact.registrar(p);
			// validar el resultado del proceso de registro
			if (ok == 0) {
				mensajeError("Error en el registro");
			} else {
				mensajeExistoso("Registro Existoso");
				cargarDataParticipante();
			}

		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarParticipante();

	}

	private void eliminarParticipante() {
		// declarar variables
		int codigo, opcion;
		// obtener codigo
		codigo = getIdParticipante();
		// validar
		if (codigo == -1) {
			return;
		} else {
			// trabajar la ventana de confirmacion
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) { // si se va eliminar
				// llamar al proceso de eliminar
				int ok = Pact.eliminar(codigo);
				// validar el resultado del proceso
				if (ok == 0) {
					mensajeError("codigo no existe");
					txtIdParticipante.setText("");
					txtIdParticipante.requestFocus();

				} else {
					mensajeExistoso("paciente eliminado");
					cargarDataParticipante();
				}
			}
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		Participante part = Pact.buscarxIdParticipante(Integer.parseInt(txtIdParticipante.getText().trim()));

		if (part == null) {
			Tool.mensajeError(this, "El ID ingresado no se encuentra registrado");
		} else {

			txtIdParticipante.setText(part.getIdParticipante()+"");
			txtApellidos.setText(part.getApellido());
			txtNombres.setText(part.getApellido());
			txtDNI.setText(part.getDni());
			txtCorreo.setText(part.getCorreo());
			txtTelefono.setText(part.getTelefono() + "");

		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		arranque();
	}
}
