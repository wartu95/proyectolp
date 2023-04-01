package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;

import Validaciones.Regex;
import clases.Contrato;
import clases.Participante;
import clases.TipoContrato;

import mantenimiento.GestionContratoDAO;
import mantenimiento.ObjetoContratoDAO;
import mantenimiento.ParticipanteDAO;
import mantenimiento.GestionTipoContratoDAO;
import utils.Tool;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrmContrato extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIDcontrato;
	private JLabel lblObjetoContrato;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JLabel lblFecha;
	private JTextField txtEstado;
	private JLabel lblDescrip;
	private JLabel lblEstado;
	private JTable tbContrato;
	private JDateChooser dcFecha;
	private JLabel lblTipoContrato;
	private JComboBox<Object> cboTipo;
	private JLabel lblNroPedido;
	private JPanel panel2;
	private JTextField txtDescripcion;
	private GestionTipoContratoDAO tipContDao;
	private GestionContratoDAO contDao;
	private ParticipanteDAO partDao;
	

	// instanciar un objeto para modelar la tabla
	DefaultTableModel model = new DefaultTableModel();

	// instanciar
	GestionContratoDAO gCont = new GestionContratoDAO();

	GestionTipoContratoDAO gtipcon = new GestionTipoContratoDAO();

	private GestionContratoDAO conDAO;
	private JTextField txtResolucion;
	private JLabel lblResolucin;
	private JLabel lblIdParticipante;
	public static JTextField txtParticipante;
	private JLabel lblNombreCompleto;
	public static JTextField txtNombre;
	private JScrollPane scrollPane;
	private JLabel lblDni;
	public static JTextField txtDni;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnBuscarParticipante;
	private JLabel lblApellido;
	public static JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmContrato frame = new FrmContrato();
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
	public FrmContrato() {
		
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		setTitle("Mantenimiento de Contrato");
		
		setBounds(100, 100, 706, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(226, 288, 104, 20);
		contentPane.add(btnRegistrar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(340, 288, 104, 20);
		contentPane.add(btnModificar);

		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "CONTRATO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(10, 11, 674, 267);
		contentPane.add(panel2);
		panel2.setLayout(null);

		txtIDcontrato = new JTextField();
		txtIDcontrato.setBounds(10, 46, 128, 20);
		panel2.add(txtIDcontrato);
		txtIDcontrato.setColumns(10);

		lblObjetoContrato = new JLabel("Participante  :");
		lblObjetoContrato.setBounds(10, 76, 96, 14);
		panel2.add(lblObjetoContrato);

		lblTipoContrato = new JLabel("Tipo de Contrato:");
		lblTipoContrato.setBounds(10, 159, 113, 14);
		panel2.add(lblTipoContrato);

		cboTipo = new JComboBox<Object>();
		cboTipo.setBounds(10, 179, 188, 22);
		panel2.add(cboTipo);

		lblFecha = new JLabel("Fecha Inicio :");
		lblFecha.setBounds(216, 21, 86, 14);
		panel2.add(lblFecha);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(215, 46, 122, 20);
		panel2.add(dcFecha);

		lblDescrip = new JLabel("Descripcion de Contrato :");
		lblDescrip.setBounds(216, 169, 226, 14);
		panel2.add(lblDescrip);

		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(462, 21, 46, 14);
		panel2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(463, 46, 86, 20);
		panel2.add(txtEstado);
		txtEstado.setColumns(10);

		lblNroPedido = new JLabel("ID Contrato:");
		lblNroPedido.setBounds(10, 21, 72, 14);
		panel2.add(lblNroPedido);

		txtDescripcion = new JTextField();
		txtDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescripcion.setBounds(216, 193, 447, 64);
		panel2.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtResolucion = new JTextField();
		txtResolucion.setColumns(10);
		txtResolucion.setBounds(559, 46, 86, 20);
		panel2.add(txtResolucion);

		lblResolucin = new JLabel("Resoluci\u00F3n  :");
		lblResolucin.setBounds(559, 21, 72, 14);
		panel2.add(lblResolucin);

		lblIdParticipante = new JLabel("ID Participante  :");
		lblIdParticipante.setBounds(10, 100, 90, 15);
		panel2.add(lblIdParticipante);

		txtParticipante = new JTextField();
		txtParticipante.setColumns(10);
		txtParticipante.setBounds(10, 125, 128, 20);
		panel2.add(txtParticipante);

		lblNombreCompleto = new JLabel("Nombre :");
		lblNombreCompleto.setBounds(228, 100, 113, 15);
		panel2.add(lblNombreCompleto);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(228, 125, 122, 20);
		panel2.add(txtNombre);

		lblDni = new JLabel("DNI  :");
		lblDni.setBounds(550, 100, 113, 15);
		panel2.add(lblDni);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(548, 125, 105, 20);
		panel2.add(txtDni);
		
		btnBuscarParticipante = new JButton("");
		btnBuscarParticipante.addActionListener(this);
		btnBuscarParticipante.setIcon(new ImageIcon(FrmContrato.class.getResource("/img/query.png")));
		btnBuscarParticipante.setBounds(152, 115, 66, 41);
		panel2.add(btnBuscarParticipante);
		
		lblApellido = new JLabel("Apellido  :");
		lblApellido.setBounds(367, 100, 113, 15);
		panel2.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(367, 125, 122, 20);
		panel2.add(txtApellido);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 312, 672, 165);
		contentPane.add(scrollPane);

		tbContrato = new JTable();
		scrollPane.setViewportView(tbContrato);
		tbContrato.setFillsViewportHeight(true);

		model.addColumn("ID CONTRATO");
		model.addColumn("TIPO");
		model.addColumn("PARTICIPANTE");
		model.addColumn("FECHA ");
		model.addColumn("DESCRIPCION");
		model.addColumn("RESOLUCION");
		model.addColumn("ESTADO");
		// asociar
		tbContrato.setModel(model);
		
		btnNewButton = new JButton("ELIMINAR");
		btnNewButton.setBounds(451, 288, 104, 20);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("NUEVO");
		btnNewButton_1.setBounds(562, 288, 110, 21);
		contentPane.add(btnNewButton_1);

		
		cargarTipoContrato();
	}

	private void arranque() {
		estado();
		cargarTipoContrato();
		cargarTabla();
		limpiar();

	}

	private void limpiar() {
		dcFecha.setDate(new Date());
		txtDescripcion.setText("");
		txtEstado.setText("REGISTRADO");

	}

	

	private void cargarTipoContrato() {

		ArrayList<TipoContrato> list = gtipcon.listarTipoContrato();

		cboTipo.removeAllItems();
		cboTipo.addItem("SELECCIONE..");

		for (TipoContrato tipCont : list) {

			cboTipo.addItem(tipCont.getIdTipoContrato() + ". " + tipCont.getDescripTipo());

		}

	}

	private void estado() {
		/*
		 * ArrayList<Participante> listPart = partDao.listarParticipante();
		 * ArrayList<Contrato> listCont = conDAO.listarContrato();
		 * 
		 * for (Participante part : listPart) {
		 * 
		 * for (Contrato con : listCont) { if
		 * (part.getIdContrato().equals(con.getCodigo())) { con.setEstado("EN PROCESO");
		 * contDao.actualizarContrato(con); } } }
		 * 
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarParticipante) {
			actionPerformedBtnBuscarParticipante(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}

	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrar();
		cargarTabla();
	}

	private void registrar() {
		String idCont, fecha, descrip, resolu, estado;
		int tipCont, Partic;

		idCont = getidCont();
		tipCont = gettipCont();
		Partic = getPartic();
		fecha = getfecha();
		descrip = getdescrip();
		resolu = getresolu();
		estado = getestado();

		// validar
		if (idCont == null || tipCont == -1 || Partic == -1 || fecha == null || descrip == null || resolu == null
				|| estado == null) {
			return;
		} else {

			// Mostrar informacion en la tabla
			Contrato cont = new Contrato();
			// setear
			cont.setIdContrato(idCont);
			cont.setTiPoContrato(tipCont);
			cont.setIdParticipante(Partic);
			cont.setFecha(fecha);
			cont.setDescripcion(descrip);
			cont.setResulucion(resolu);
			cont.setEstado(estado);

			// llamar al proceso de registro
			int ok = gCont.registrar(cont);

			// validar
			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro del contrato");
			} else {
				Tool.mensajeExito(this, "Registro exitoso");
			}

			Object fila[] = { idCont, tipCont, Partic, fecha, descrip, resolu, estado };

			// Agregar la fila en la tabla

			model.addRow(fila);

		}

	}

	private String getestado() {

		return txtEstado.getText();
	}

	private String getresolu() {

		return txtResolucion.getText();
	}

	private String getdescrip() {
		String desc = null;

		if (txtDescripcion.getText().trim().length() == 0) {
			Tool.mensajeError(this, "El contrato necesita una descripcion");
			txtDescripcion.requestFocus();
		} else {
			desc = txtDescripcion.getText().trim();
		}
		return desc;
	}

	private String getfecha() {
		String fecha = null;

		if (dcFecha.getDate() == null) {
			Tool.mensajeError(this, "El campo fecha esta vacio !");
			dcFecha.requestFocus();
		} else {
			fecha = Tool.sdf.format(dcFecha.getDate()).toString();
		}

		return fecha;

	}

	private int getPartic() {

		return Integer.parseInt(txtParticipante.getText());
	}

	private int gettipCont() {
		int res = -1;

		
		 if (cboTipo.getSelectedIndex() == 0) { Tool.mensajeError(this,"Elige un tipo de pedido"); 
		 } else { res = cboTipo.getSelectedIndex(); }
		 
		return res;
		//return Integer.parseInt(cboTipo.getSelectedItem().toString());
	}

	private String getidCont() {
		// Formato --> P0001 ó p0001
		String idcont = null;

		// caja de texto vacio
		if (txtIDcontrato.getText().trim().length() == 0) {
			Tool.mensajeError(this, "Ingrese el Codigo del contrato");
			txtIDcontrato.setText("");
			txtIDcontrato.requestFocus();
			//
		} else if (txtIDcontrato.getText().trim().matches("[Cc][0-9]{4}")) {
			idcont = txtIDcontrato.getText();
		} else {
			Tool.mensajeError(this, "Formato no valido Ejem. C001 - c001");
			txtIDcontrato.setText("");
			txtIDcontrato.requestFocus();
		}

		return idcont;
	}

	private void cargarTabla() {
		ArrayList<Contrato> list = gCont.listarContrato();

		model.setRowCount(0);

		for (Contrato p : list) {

			Object[] cont = { p.getIdContrato(), p.getTiPoContrato(), p.getIdParticipante(), p.getFecha(),
					p.getDescripcion(), p.getResulucion(), p.getEstado()

			};

			model.addRow(cont);

		}

	}

	

	private String leerEstado() {
		String res = null;

		if (txtEstado.getText().trim().length() == 0) {
			Tool.mensajeError(this, "El campo estado esta vac�o !");
			txtEstado.requestFocus();
		} else {
			res = txtEstado.getText().toString();
		}

		return res;
	}

	private String leerFecha() {
		String res = null;

		if (dcFecha.getDate() == null) {
			Tool.mensajeError(this, "El campo fecha esta vacio !");
			dcFecha.requestFocus();
		} else {
			res = Tool.sdf.format(dcFecha.getDate()).toString();
		}

		return res;
	}

	private String leerDescripcion() {
		String res = null;

		if (txtDescripcion.getText().trim().length() == 0) {
			Tool.mensajeError(this, "El registro necesita un descripcion");
			txtDescripcion.requestFocus();
		} else {
			res = txtDescripcion.getText().trim();
		}
		return res;
	}
	private String leerIdContrato() {
		String res = null;

		if (txtIDcontrato.getText().trim().length() == 0) {
			Tool.mensajeError(this, "Campo del id pedido esta vacio !");
			txtIDcontrato.requestFocus();
		} else if (txtIDcontrato.getText().trim().matches(Regex.ID_CONTRATO)) {
			res = txtIDcontrato.getText().trim();
		} else {
			Tool.mensajeError(this, "ID pedido invalido. Ejemp (CD002)");
			txtIDcontrato.requestFocus();
		}

		return res;
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		/*
		 * String idCodigo = leerIdContrato(); String entidad = leerEntidad(); String
		 * ruc = leerRuc(); int idTipoContrato = leerTipo(); int idObjetoContrato =
		 * leerObjeto(); String descripcion = leerDescripcion(); String fecha =
		 * leerFecha(); String estado = leerEstado();
		 * 
		 * if (idCodigo == null || entidad == null || ruc == null || idTipoContrato ==
		 * -1 || idObjetoContrato == -1 || descripcion == null || fecha == null ||
		 * estado == null) { return; } else {
		 * 
		 * Contrato cont = new Contrato(idCodigo, entidad, ruc, idTipoContrato,
		 * idObjetoContrato, descripcion, fecha, estado);
		 * 
		 * int ok = contDao.actualizarContrato(cont);
		 * 
		 * if (ok == 0) { Tool.mensajeError(this, "Error de update"); } else {
		 * Tool.mensajeExito(this, "Pedido actualizado!"); cargarTabla(); } }
		 */
	}
	protected void actionPerformedBtnBuscarParticipante(ActionEvent e) {
		DlgListParticipante dl = new DlgListParticipante();
		dl.setVisible(true);
	}
}
