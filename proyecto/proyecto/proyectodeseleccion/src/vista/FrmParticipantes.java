package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import utils.Tool;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

import Validaciones.Regex;
import clases.Admin;
import clases.Contrato;
import clases.Participante;
import mantenimiento.AdminDAO;
import mantenimiento.ContratoDAO;
import mantenimiento.ParticipanteDAO;

import javax.swing.JScrollPane;

public class FrmParticipantes extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */

	private JPanel contentPane;
	private JLabel lblContrato;
	private JButton btnNuevo;
	private JTable tbParticipante;
	private JButton btnBuscarContrato;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblIdContrato;
	private JButton btnBuscar;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_7;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtNombres;
	private JLabel lblNombres;
	private JTextField txtDNI;
	private JLabel lblDNI;
	private JLabel lblDni;

	// instanciar un objeto para modelar la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private ParticipanteDAO partDao;
	private AdminDAO admDao;
	private JTextField txtContrato;
	private JTextField txtIdParticipante;
	private ContratoDAO contDao;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmParticipantes frame = new FrmParticipantes();
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
	public FrmParticipantes() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Participantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 971, 245);
		contentPane.add(scrollPane);

		tbParticipante = new JTable();
		scrollPane.setViewportView(tbParticipante);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "CONTRATO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 21, 134, 121);
		contentPane.add(panel);
		panel.setLayout(null);

		lblContrato = new JLabel("ID Contrato:");
		lblContrato.setBounds(10, 22, 72, 14);
		panel.add(lblContrato);

		btnBuscarContrato = new JButton("");
		btnBuscarContrato.setBounds(10, 73, 33, 23);
		panel.add(btnBuscarContrato);

		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(63, 73, 33, 23);
		panel.add(btnNuevo);
		
		txtContrato = new JTextField();
		txtContrato.setEditable(false);
		txtContrato.setColumns(10);
		txtContrato.setBounds(10, 42, 89, 20);
		panel.add(txtContrato);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(158, 21, 823, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblIdContrato = new JLabel("ID. Participante :");
		lblIdContrato.setBounds(10, 24, 96, 14);
		panel_1.add(lblIdContrato);

		btnBuscar = new JButton("");
		btnBuscar.setBounds(128, 36, 38, 23);
		panel_1.add(btnBuscar);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 70, 75, 14);
		panel_1.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(10, 90, 156, 20);
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);

		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(186, 24, 63, 14);
		panel_1.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(185, 39, 86, 20);
		panel_1.add(txtEstado);
		txtEstado.setColumns(10);

		lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(332, 121, 75, 14);
		panel_1.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(332, 143, 156, 20);
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

		lblNewLabel_7 = new JLabel("TABLA DE PARTICIPANTE");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(0, 206, 922, 23);
		contentPane.add(lblNewLabel_7);

		btnAgregar = new JButton("REGISTRAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregar(e);
			}
		});
		btnAgregar.setBounds(213, 487, 89, 23);
		contentPane.add(btnAgregar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(419, 487, 112, 23);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(611, 487, 89, 23);
		contentPane.add(btnEliminar);

		// agregar columna
		model.addColumn("ID CONTRATO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("APELLIDOS");
		model.addColumn("NOMBRES");
		model.addColumn("DNI");
		model.addColumn("TELEFONO");
		model.addColumn("DIRECCION");
		model.addColumn("CORREO");

		// asociar tabla
		tbParticipante.setModel(model);

		new AdminDAO();
		partDao = new ParticipanteDAO();
		admDao = new AdminDAO();

		arranque();
	}

	private void arranque() {
		estado();
		cargarTabla();
		correlativo();
		limpiar();
	}

	private void limpiar() {
		txtContrato.setEditable(false);
		txtIdParticipante.setEditable(false);
		txtApellidos.setEditable(false);
		txtNombres.setEditable(false);
		txtDNI.setEditable(false);
		txtTelefono.setEditable(false);
		txtCorreo.setEditable(false);
		txtEstado.setText("REGISTRADO");
		
	}

	private void correlativo() {
		@SuppressWarnings("resource")
		Formatter ft = new Formatter();
		
		ArrayList <Participante> list = partDao.listarParticipante();
		
		if (list.size()==0) {
			txtIdParticipante.setText("PA001");
		}else {
			String idParticipante = list.get(list.size()-1).getIdParticipante();
			
			int n =Integer.parseInt(idParticipante.substring(3))+1;
			
			txtIdParticipante.setText("");
			txtIdParticipante.setText("PA"+ft.format("%03d", n));
		}
		
		
	}

	private void cargarTabla() {
ArrayList<Participante> list = partDao.listarParticipante();
		
		modelo.setRowCount(0);
		
		for (Participante part: list) {
			
			Object [] x = {
					part.getIdContrato(),
					part.getIdParticipante(),
					part.getApellido(),
					part.getNombre(),
					part.getDni(),
					part.getTelefono(),
					part.getDireccion(),
					part.getCorreo(),
					part.getFecha(),
					part.getEstado()
			};
			
			modelo.addRow(x);
		}
		
	}

	private void estado() {
		ArrayList<Participante> listPart = partDao.listarParticipante();
		ArrayList<Contrato> listCont = contDao.listarContrato();
		
		for (Participante part : listPart) {
			
			for (Contrato cont : listCont) {
				if (part.getIdContrato().equals(cont.getCodigo())) {
					cont.setEstado("EN PROCESO");
					contDao.actualizarContrato(cont);
				}
			}
		}
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		// TODO Auto-generated method stub

	}

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		String idContrato = leerIdContrato();
		String idParticipante = leerIdParticipante();
		String apellido = leerApellido();
		String nombre = leerNombre();
		String dni = leerDni();
		int telefono = leerTelefono();
		String direccion = leerDireccion();
		String correo = leerCorreo();
		String fecha = leerFecha();
		String estado = leerEstado();

		if (idContrato == null || idParticipante == null || apellido == null || nombre == null || dni == null
				|| telefono == -1 || direccion == null || correo == null || fecha == null || estado == null) {

			return;

		}else {
			ArrayList<Admin> listCep = admDao.listarAdminXContrato(idContrato);
			
			if (listCep.size() == 3) {
				Participante part = new Participante (
						
						idContrato, idParticipante, apellido, nombre, dni, telefono, direccion, correo, fecha, estado
						);
				
				int ok =partDao.registrarParticipante(part);
				
				if (ok == 0) {
					Tool.mensajeExito(this,"Registro exitoso");
				}else {
					Tool.mensajeExito(this, "Registro exitoso");
					cargarTabla();
					correlativo();
				}
			}else {
				Tool.mensajeError(this,"Pedido no cuenta con la cantidad de Miembros del Comité necesarios");
			}
			
		}

	}

	private String leerEstado() {
		return null;
	}

	private String leerFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerCorreo() {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerDireccion() {
		// TODO Auto-generated method stub
		return null;
	}

	private int leerTelefono() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String leerDni() {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerApellido() {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerIdParticipante() {
		String res = null;

		if (txtIdParticipante.getText().trim().length() == 0) {
			Tool.mensajeError(this, "El campo del ID participante está vacío !");
			txtIdParticipante.requestFocus();
		} else if (txtIdParticipante.getText().trim().matches(Regex.ID_PARTICIPANTE)) {
			res = txtIdParticipante.getText().trim();
		} else {
			Tool.mensajeError(this, "ID inválido. Ejemp (PA002)");
		}

		return res;
	}

	private String leerIdContrato() {
		String res = null;

		if (txtContrato.getText().trim().length() == 0) {
			Tool.mensajeError(this,"Eliga el ID del algún pedido. Presione la opcion buscar !");;
		}
		res = txtContrato.getText();

		return res;
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		arranque();
	}
}
