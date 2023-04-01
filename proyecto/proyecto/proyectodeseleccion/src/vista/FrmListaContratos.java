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

public class FrmListaContratos extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private TipoContratoDAO tipContDao;
	private ObjetoContratoDAO objContDao;
	private GestionContratoDAO contDao;
	private ParticipanteDAO partDao;
	private AdminDAO adminDao;
	
	
	//instanciar un objeto para modelar la tabla
	DefaultTableModel model= new DefaultTableModel();
	private GestionContratoDAO conDAO;
	private JTable tbContratos;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListaContratos frame = new FrmListaContratos();
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
	public FrmListaContratos() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("CONTRATOS ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		model.addColumn("ID CONTRATO");
		model.addColumn("ENTIDAD");

		model.addColumn("TIPO");
		model.addColumn("OBJETO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
		model.addColumn("ESTADO");
		
		tbContratos = new JTable();
		tbContratos.setBounds(10, 20, 674, 536);
		contentPane.add(tbContratos);

		
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
		
	}

	private void cargarObjetoContrato() {
ArrayList<ObjContrato> list = ObjetoContratoDAO.listarObjContrato();
		
		for (ObjContrato objCont : list) {
			
			cboObjeto.addItem(objCont.getIdObjContato() + ". " + objCont.getDesObjContrato());
			
		}
		
		
	}

	private void cargarTipoContrato() {
	
		ArrayList<TipoContrato> list = tipContDao.listarTipoContrato();
		
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
}
