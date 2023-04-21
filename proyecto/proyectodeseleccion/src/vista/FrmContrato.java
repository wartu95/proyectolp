package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;

import clases.Contrato;
import clases.DetalleContrato;
import clases.Participante;
import clases.TipoContrato;

import mantenimiento.GestionContratoDAO;
import mantenimiento.GestionTipoContratoDAO;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionParticipanteDAO;
import utils.Validaciones;
import utils.Tool;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicToolBarSeparatorUI;
import javax.swing.table.DefaultTableModel;
import javax.tools.DocumentationTool.Location;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FrmContrato extends JInternalFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtIDcontrato;
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
	private GestionParticipanteDAO partDao;

	// instanciar un objeto para modelar la tabla
	DefaultTableModel model = new DefaultTableModel();

	// instanciar
	GestionContratoDAO gCont = new GestionContratoDAO();

	GestionTipoContratoDAO gtipcon = new GestionTipoContratoDAO();

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
	private JPanel panel;
	private JTable tableVisado;
	private DefaultTableModel modelVisado;
	private JScrollPane scrollPane_1;

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

		setBounds(100, 100, 745, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(FrmContrato.class.getResource("/img/Registro-Contrato.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 303, 49, 41);
		contentPane.add(btnRegistrar);

		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(FrmContrato.class.getResource("/img/Modificar-contrato.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(69, 303, 41, 41);
		contentPane.add(btnModificar);

		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "CONTRATO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(10, 5, 395, 272);
		contentPane.add(panel2);
		panel2.setLayout(null);

		txtIDcontrato = new JTextField();
		txtIDcontrato.setBounds(10, 46, 128, 20);
		panel2.add(txtIDcontrato);
		txtIDcontrato.setColumns(10);

		lblTipoContrato = new JLabel("Tipo de Contrato:");
		lblTipoContrato.setBounds(10, 72, 113, 14);
		panel2.add(lblTipoContrato);

		cboTipo = new JComboBox<Object>();
		cboTipo.setBounds(10, 92, 188, 22);
		panel2.add(cboTipo);

		lblFecha = new JLabel("Fecha Inicio :");
		lblFecha.setBounds(149, 21, 86, 14);
		panel2.add(lblFecha);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(148, 46, 122, 20);
		panel2.add(dcFecha);

		lblDescrip = new JLabel("Descripcion de Contrato :");
		lblDescrip.setBounds(10, 125, 226, 14);
		panel2.add(lblDescrip);

		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(280, 21, 46, 14);
		panel2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(281, 46, 86, 20);
		panel2.add(txtEstado);
		txtEstado.setColumns(10);

		lblNroPedido = new JLabel("ID Contrato:");
		lblNroPedido.setBounds(10, 21, 72, 14);
		panel2.add(lblNroPedido);

		txtDescripcion = new JTextField();
		txtDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescripcion.setBounds(10, 149, 270, 100);
		panel2.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtResolucion = new JTextField();
		txtResolucion.setColumns(10);
		txtResolucion.setBounds(217, 94, 109, 45);
		panel2.add(txtResolucion);

		lblResolucin = new JLabel("Resoluci\u00F3n  :");
		lblResolucin.setBounds(217, 72, 72, 14);
		panel2.add(lblResolucin);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 348, 672, 165);
		contentPane.add(scrollPane);

		tbContrato = new JTable();
		tbContrato.addMouseListener(this);
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

		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmContrato.class.getResource("/img/delete-contrato.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(131, 303, 41, 41);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmContrato.class.getResource("/img/new-document.png")));
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(196, 303, 41, 41);
		contentPane.add(btnNewButton_1);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(406, 5, 305, 177);
		contentPane.add(panel);
		panel.setLayout(null);

		txtParticipante = new JTextField();
		txtParticipante.setBounds(23, 44, 128, 20);
		panel.add(txtParticipante);
		txtParticipante.setColumns(10);

		lblIdParticipante = new JLabel("ID Participante  :");
		lblIdParticipante.setBounds(23, 29, 90, 15);
		panel.add(lblIdParticipante);

		btnBuscarParticipante = new JButton("");
		btnBuscarParticipante.setBounds(161, 29, 66, 41);
		panel.add(btnBuscarParticipante);
		btnBuscarParticipante.addActionListener(this);
		btnBuscarParticipante.setIcon(new ImageIcon(FrmContrato.class.getResource("/img/query.png")));

		txtNombre = new JTextField();
		txtNombre.setBounds(23, 86, 122, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		// deshabilitar cajas de texto del nombre
		txtNombre.setEditable(false);

		lblNombreCompleto = new JLabel("Nombre :");
		lblNombreCompleto.setBounds(20, 71, 113, 15);
		panel.add(lblNombreCompleto);

		lblApellido = new JLabel("Apellido  :");
		lblApellido.setBounds(160, 71, 123, 15);
		panel.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(155, 86, 123, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.setEditable(false);

		txtDni = new JTextField();
		txtDni.setBounds(25, 132, 105, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		txtDni.setEditable(false);

		lblDni = new JLabel("DNI  :");
		lblDni.setBounds(25, 117, 113, 15);
		panel.add(lblDni);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(415, 193, 283, 120);
		contentPane.add(scrollPane_1);

		tableVisado = new JTable();
		scrollPane_1.setViewportView(tableVisado);

		modelVisado = new DefaultTableModel();
		modelVisado.addColumn("ID VISADO");
		modelVisado.addColumn("ID USUARIO");
		modelVisado.addColumn("ESTADO");
		tableVisado.setModel(modelVisado);

		arranque();
	}

	private void arranque() {
		cargarTipoContrato();
		cargarTabla();
		limpiar();

	}

	private void limpiar() {
		dcFecha.setDate(null);
		txtDescripcion.setText("");
		txtEstado.setText("EN REGISTRO");
		txtIDcontrato.setEditable(false);
		txtIDcontrato.setText(obtenercodContrato());
		txtApellido.setText("");
		txtNombre.setText("");
		txtParticipante.setText("");
		txtResolucion.setText("");
		txtDni.setText("");
		cboTipo.setSelectedIndex(0);

	}

	private String obtenercodContrato() {
		// TODO Auto-generated method stub
		return gCont.codContrato();
	}

	private void cargarTipoContrato() {

		ArrayList<TipoContrato> list = gtipcon.listarTipoContrato();

		cboTipo.removeAllItems();
		cboTipo.addItem("SELECCIONE..");

		for (TipoContrato tipCont : list) {

			cboTipo.addItem(tipCont.getIdTipoContrato() + ". " + tipCont.getDescripTipo());

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
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
			cont.setResolucion(resolu);
			cont.setEstado(estado);

			// llamar al proceso de registro
			int ok = gCont.registrar(cont);

			// validar
			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro del contrato");
			} else {
				Tool.mensajeExito(this, "Registro exitoso");
				cargarTabla();
			}

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

		if (cboTipo.getSelectedIndex() == 0) {
			Tool.mensajeError(this, "Elige un tipo de pedido");
		} else {
			res = cboTipo.getSelectedIndex();
		}

		return res;

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
					p.getDescripcion(), p.getResolucion(), p.getEstado()

			};

			model.addRow(cont);

		}

	}

	protected void actionPerformedBtnModificar(ActionEvent e) {

		String idCont = getidCont();
		int tipCont = gettipCont();
		int Partic = getPartic();
		String fecha = getfecha();
		;
		String descrip = getdescrip();
		String resolu = getresolu();
		String estado = getestado();

		if (idCont == null || tipCont == -1 || Partic == -1 || fecha == null || descrip == null || resolu == null
				|| estado == null) {
			return;
		} else {

			Contrato cont = new Contrato();

			cont.setTiPoContrato(tipCont);
			cont.setIdParticipante(Partic);
			cont.setFecha(fecha);
			cont.setDescripcion(descrip);
			cont.setResolucion(resolu);
			cont.setEstado(estado);
			cont.setIdContrato(idCont);

			int ok = gCont.actualizarContrato(cont);

			if (ok == 0) {
				Tool.mensajeError(this, "Error en la Actualizacion de datos del contrato");
			} else {
				Tool.mensajeExito(this, "Contrato Actualizado!");
				cargarTabla();
			}
		}

	}

	protected void actionPerformedBtnBuscarParticipante(ActionEvent e) {
		DlgListParticipante dl = new DlgListParticipante();
		dl.setVisible(true);
	}

	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		limpiar();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbContrato) {
			mouseClickedTbContrato(e);
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

	protected void mouseClickedTbContrato(MouseEvent e) {
		int posfila;
		posfila = tbContrato.getSelectedRow();
		// Mostrar data
		Mostrardata(posfila);

	}

	private void Mostrardata(int posfila) {
		String idcont, idpart, fec, descrip, resol, estad;
		Date fechh;
		int tipcont;

		idcont = tbContrato.getValueAt(posfila, 0).toString();
		tipcont = Integer.parseInt(tbContrato.getValueAt(posfila, 1).toString());
		// tipcont= tbContrato.getValueAt(posfila, 1).toString();
		idpart = tbContrato.getValueAt(posfila, 2).toString();
		fec = tbContrato.getValueAt(posfila, 3).toString();
		descrip = tbContrato.getValueAt(posfila, 4).toString();
		resol = tbContrato.getValueAt(posfila, 5).toString();
		estad = tbContrato.getValueAt(posfila, 6).toString();

		// Mostrar en la caja de texto

		txtIDcontrato.setText(idcont);
		txtParticipante.setText(idpart);
		cboTipo.setSelectedIndex(tipcont);
		txtEstado.setText(estad);

		try {
			dcFecha.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtDescripcion.setText(descrip);
		txtResolucion.setText(resol);
		txtEstado.setText(estad);
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {

		String idcont;
		int opcion;
		// obtener el id
		idcont = getidCont();
		// validar
		if (idcont == null) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar el contrato", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				// llamar al proceso eliminar
				int ok = gCont.eliminarContrato(idcont);
				// validar el resultado del proceso
				if (ok == 0) {
					Tool.mensajeError(this, "El Id del contrato no existe");
				} else {
					Tool.mensajeExito(this, "Contrato eliminado");
					cargarTabla();

				}
			}
		}
	}

}
