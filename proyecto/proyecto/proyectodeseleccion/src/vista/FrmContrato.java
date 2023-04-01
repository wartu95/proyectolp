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
import clases.ObjContrato;
import clases.Participante;
import clases.TipoContrato;
import mantenimiento.AdminDAO;
import mantenimiento.GestionContratoDAO;
import mantenimiento.ObjetoContratoDAO;
import mantenimiento.ParticipanteDAO;
import mantenimiento.TipoContratoDAO;
import utils.Tool;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

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
	private JButton btnNuevo;
	private JTextField txtDescripcion;
	private TipoContratoDAO tipContDao;
	private ObjetoContratoDAO objContDao;
	private GestionContratoDAO contDao;
	private ParticipanteDAO partDao;
	private AdminDAO adminDao;
	
	
	//instanciar un objeto para modelar la tabla
	DefaultTableModel model= new DefaultTableModel();
	private GestionContratoDAO conDAO;
	private JTextField textField;
	private JLabel lblResolucin;
	private JLabel lblIdParticipante;
	private JTextField textField_1;
	private JButton btnNuevo_1;
	private JLabel lblNombreCompleto;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	private JLabel lblDni;
	private JTextField textField_3;

	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(466, 288, 104, 20);
		contentPane.add(btnRegistrar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(580, 288, 104, 20);
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

		cboTipo = new JComboBox();
		cboTipo.setBounds(10, 179, 146, 22);
		panel2.add(cboTipo);

		lblFecha = new JLabel("Fecha Inicio :");
		lblFecha.setBounds(216, 21, 86, 14);
		panel2.add(lblFecha);

		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(148, 46, 46, 23);
		panel2.add(btnNuevo);

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
		txtDescripcion.setBounds(216, 193, 447, 64);
		panel2.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(559, 46, 86, 20);
		panel2.add(textField);
		
		lblResolucin = new JLabel("Resoluci\u00F3n  :");
		lblResolucin.setBounds(559, 21, 72, 14);
		panel2.add(lblResolucin);
		
		lblIdParticipante = new JLabel("ID Participante  :");
		lblIdParticipante.setBounds(10, 100, 90, 15);
		panel2.add(lblIdParticipante);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 125, 128, 20);
		panel2.add(textField_1);
		
		btnNuevo_1 = new JButton("");
		btnNuevo_1.addActionListener(this);
		btnNuevo_1.setBounds(161, 122, 46, 23);
		panel2.add(btnNuevo_1);
		
		lblNombreCompleto = new JLabel("Nombre Completo  :");
		lblNombreCompleto.setBounds(228, 100, 113, 15);
		panel2.add(lblNombreCompleto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 125, 226, 20);
		panel2.add(textField_2);
		
		lblDni = new JLabel("DNI  :");
		lblDni.setBounds(482, 100, 113, 15);
		panel2.add(lblDni);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(480, 125, 105, 20);
		panel2.add(textField_3);

		
		model.addColumn("ID CONTRATO");
		model.addColumn("ENTIDAD");

		model.addColumn("TIPO");
		model.addColumn("OBJETO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
		model.addColumn("ESTADO");
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 312, 672, 165);
				contentPane.add(scrollPane);
		
				tbContrato = new JTable();
				scrollPane.setViewportView(tbContrato);
				tbContrato.setFillsViewportHeight(true);
				
				//asociar 
				tbContrato.setModel(model);

		
		partDao = new ParticipanteDAO();
		adminDao = new AdminDAO();
		conDAO = new GestionContratoDAO();
		
		
		arranque();

	}

	private void arranque() {
		estado();
		cargarTipoContrato();
		cargarObjetoContrato();
		correlativo();
		cargarTabla();
		limpiar();
		
	}

	private void limpiar() {
		dcFecha.setDate(new Date());
		txtDescripcion.setText("");
		txtEstado.setText("REGISTRADO");
		
	}

	private void cargarObjetoContrato() {
ArrayList<ObjContrato> list = ObjetoContratoDAO.listarObjContrato();
		
		for (ObjContrato objCont : list) {
			
			cboObjeto.addItem(objCont.getIdObjContato() + ". " + objCont.getDesObjContrato());
			
		}
		
		
	}

	private void cargarTipoContrato() {
	
		ArrayList<TipoContrato> list = tipContDao.listarTipoContrato();
		
		cboTipo.removeAllItems();
		cboTipo.addItem("SELECCIONE..");
		
		for (TipoContrato tipCont : list) {
			
			cboTipo.addItem(tipCont.getIdTipoContrato() + ". " + tipCont.getDesTipoContrato());
			
		}
		
	}

	private void estado() {
		ArrayList<Participante> listPart = partDao.listarParticipante();
		ArrayList<Contrato> listCont  = conDAO.listarContrato(); 

		for (Participante part : listPart) {
			
			for (Contrato con : listCont) {
				if (part.getIdContrato().equals(con.getCodigo())) {
					con.setEstado("EN PROCESO");
					contDao.actualizarContrato(con);
				}
			}
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo_1) {
			actionPerformedBtnNuevo_1(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}

	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String idcontrato = leerIdContrato();
		String entidad = leerEntidad();
		String ruc = leerRuc();
		int idTipoPedido = leerTipo();
		int idObjetoPedido = leerObjeto();
		String descripcion = leerDescripcion();
		String fecha = leerFecha();
		String estado = leerEstado();

		if (idcontrato == null || entidad == null || ruc == null || idTipoPedido == -1 || idObjetoPedido == -1
				|| descripcion == null || fecha == null || estado == null) {
			return;
		} else {
			Contrato ped = new Contrato(idcontrato, entidad, ruc, idTipoPedido, idObjetoPedido, descripcion, fecha,
					estado);

			int ok = contDao.registrarPedido(ped);

			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro");
			} else {
				Tool.mensajeExito(this, "Pedido registrado!");
				correlativo();
				cargarTabla();
			}
		}
	}

	private void cargarTabla() {
		ArrayList<Contrato> list = contDao.listarContrato();

		model.setRowCount(0);

		for (Contrato p : list) {

			Object[] cont = { p.getCodigo(), 
					p.getEntidad(), 
					p.getTipo(), 
					p.getObjeto(), 
					p.getDescripcion(),
					p.getFecha(),
					p.getEstado(),
					p.getRuc()
		};

			model.addRow(cont);

		}

	}

	private void correlativo() {
		@SuppressWarnings("resource")
		Formatter ft = new Formatter();

		ArrayList<Contrato> list = contDao.listarContrato();

		if (list.size() == 0) {
			txtIDcontrato.setText("PD001");
		} else {
			String idPedido = list.get(list.size() - 1).getCodigo();

			int correlativo = Integer.parseInt(idPedido.substring(2)) + 1;

			txtIDcontrato.setText("PD" + ft.format("%03d", correlativo));

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

	private int leerObjeto() {
		int res = -1;

		if (cboObjeto.getSelectedIndex() == 0) {
			Tool.mensajeError(this, "Elige un objeto de contratacion");
		} else {
			res = cboObjeto.getSelectedIndex();
		}

		return res;
	}

	private int leerTipo() {
		int res = -1;

		if (cboTipo.getSelectedIndex() == 0) {
			Tool.mensajeError(this, "Elige un tipo de pedido");
		} else {
			res = cboTipo.getSelectedIndex();
		}

		return res;
	}

	private String leerRuc() {
		String res = null;

		if (txtRuc.getText().trim().length() == 0) {
			Tool.mensajeError(this, "Campo del RUC esta vacio !");
			txtRuc.requestFocus();
		} else if (txtRuc.getText().trim().matches(Regex.RUC_PEDIDO)) {
			res = txtRuc.getText();
		} else {
			Tool.mensajeError(this, "Ruc inv�alido. Ejemp (XXXXXXXXXXX, 11 digitos)");
			txtRuc.requestFocus();
		}

		return res;
	}

	private String leerEntidad() {
		String res = null;

		if (txtEntidad.getText().trim().length() == 0) {
			Tool.mensajeError(this, "Campo entidad esta vacio !");
			txtEntidad.requestFocus();
		} else if (txtEntidad.getText().trim().matches(Regex.ENTIDAD_CONTRATO)) {
			res = txtEntidad.getText().trim();
		} else {
			Tool.mensajeError(this, "Entidad invalida. Cantidad de caracteres (3 y 20)");
			txtEntidad.requestFocus();
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

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		arranque();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		String idCodigo = leerIdContrato();
		String entidad = leerEntidad();
		String ruc = leerRuc();
		int idTipoContrato = leerTipo();
		int idObjetoContrato = leerObjeto();
		String descripcion = leerDescripcion();
		String fecha = leerFecha();
		String estado = leerEstado();

		if (idCodigo == null || entidad == null || ruc == null || idTipoContrato == -1 || idObjetoContrato == -1
				|| descripcion == null || fecha == null || estado == null) {
			return;
		} else {

			Contrato cont = new Contrato(idCodigo, entidad, ruc, idTipoContrato, idObjetoContrato, descripcion, fecha,
					estado);

			int ok = contDao.actualizarContrato(cont);

			if (ok == 0) {
				Tool.mensajeError(this, "Error de update");
			} else {
				Tool.mensajeExito(this, "Pedido actualizado!");
				cargarTabla();
			}
		}

	}
	protected void actionPerformedBtnNuevo_1(ActionEvent e) {
	}
}
